package com.example.zomatoapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zomatoapp.R;
import com.example.zomatoapp.activities.CollectionActivity;
import com.example.zomatoapp.activities.RestaurantActivity;
import com.example.zomatoapp.dataModel.CityModel;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.dataModel.RestaurantsModel;
import com.example.zomatoapp.dataModel.SearchModel;
import com.example.zomatoapp.databinding.FragmentDiningLayoutBinding;
import com.example.zomatoapp.eventbus.OnCitySuccessEvent;
import com.example.zomatoapp.eventbus.OnCollectionsSuccessEvent;
import com.example.zomatoapp.eventbus.OnSearchSuccessEvent;
import com.example.zomatoapp.helper.LocationHelper;
import com.example.zomatoapp.ui.CollectionListAdapter;
import com.example.zomatoapp.ui.RestaurantListAdapter;
import com.example.zomatoapp.utils.StaticValues;
import com.example.zomatoapp.viewModel.CollectionItemViewModel;
import com.example.zomatoapp.viewModel.CommonViewModel;
import com.example.zomatoapp.viewModel.RestaurantItemViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommonFragment extends Fragment implements RestaurantItemViewModel.OnRestaurantSelectListener, CollectionItemViewModel.OnCollectionSelectListener{
    private static final String TAG = CommonFragment.class.getName();

    public static final String FRAGMENT_TYPE = "FRAGMENT_TYPE";

    public static final int DINING_FRAGMENT = 9;
    public static final int NIGHT_LIFE_FRAGMENT = 3;

    private FragmentDiningLayoutBinding mBinding;
    protected CommonViewModel mViewModel;

    private int categoryId;

    private int cityId = 0;

    private Context context;
    private RecyclerView rvCollectionsView;
    private CollectionListAdapter collectionAdapter;

    private RecyclerView rvRestaurantListView;
    private RestaurantListAdapter restaurantListAdapter;

    public List<CollectionItemViewModel> getCollectionData() {
        return collectionData;
    }

    public void setCollectionData(List<CollectionItemViewModel> collectionData) {
        this.collectionData = collectionData;
    }

    private List<CollectionItemViewModel> collectionData = new ArrayList<>();

    public List<RestaurantItemViewModel> getRestaurantData() {
        return restaurantData;
    }

    public void setRestaurantData(List<RestaurantItemViewModel> restaurantData) {
        this.restaurantData = restaurantData;
    }

    private List<RestaurantItemViewModel> restaurantData = new ArrayList<>();

    public static CommonFragment newInstance(int type) {
        CommonFragment commonFragment = new CommonFragment();
        Bundle arg = new Bundle();
        arg.putInt(FRAGMENT_TYPE, type);
        commonFragment.setArguments(arg);
        return commonFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        context = getActivity();

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dining_layout, container, false);
        mViewModel = new CommonViewModel(context);

        mBinding.setViewModel(mViewModel);

        categoryId = getArguments().getInt(FRAGMENT_TYPE, DINING_FRAGMENT);

        initView();
        EventBus.getDefault().register(this);

        LocationHelper.getInstance().getRxLocation(context, (location, address) -> {
            mViewModel.cityName.set(address.getLocality());
            mViewModel.getCityInfo(categoryId);
        });

        return mBinding.getRoot();
    }

    private void initView() {
        rvCollectionsView = mBinding.rvCollectionList;
        collectionAdapter = new CollectionListAdapter(collectionData);

        rvCollectionsView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        rvCollectionsView.setAdapter(collectionAdapter);

        rvRestaurantListView = mBinding.rvRestaurantList;
        restaurantListAdapter = new RestaurantListAdapter(restaurantData);

        rvRestaurantListView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        rvRestaurantListView.setAdapter(restaurantListAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCollectionsSuccessEvent(OnCollectionsSuccessEvent event) {
        CollectionListModel collectionListModel = event.getCollectionListModel();
        for (CollectionListModel.Collections collectionModel : collectionListModel.getCollections()) {
            CollectionItemViewModel viewModel = new CollectionItemViewModel();
            viewModel.setId(collectionModel.getCollection().getCollectionId());
            viewModel.collectionTitle.set(collectionModel.getCollection().getTitle());
            viewModel.imageUrl.set(collectionModel.getCollection().getImageUrl());
            viewModel.setListener(this);
            collectionData.add(viewModel);
        }

        collectionAdapter.setData(collectionData);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRestaurantSearchSuccessEvent(OnSearchSuccessEvent event) {
        if (event.getCategory() != categoryId) return;
        Log.d(TAG, "onRestaurantSearchSuccessEvent: event.category = " + event.getCategory() + " curr category = " + categoryId);

        SearchModel searchModel = event.getSearchModel();

        for (RestaurantsModel restaurantsModel : searchModel.getRestaurants()) {
            RestaurantModel restaurantModel = restaurantsModel.getRestaurant();
            RestaurantItemViewModel viewModel = new RestaurantItemViewModel();
            viewModel.setId(Integer.parseInt(restaurantModel.getId()));
            viewModel.name.set(restaurantModel.getName());
            viewModel.description.set(restaurantModel.getCuisines());
            viewModel.status.set(restaurantModel.getTimings());
            viewModel.location.set(restaurantModel.getLocation().getCity());
            viewModel.imageUrl.set(restaurantModel.getThumb());
            viewModel.rating.set(restaurantModel.getUserRating().getAggregateRating());
            viewModel.setListener(this);
            int priceForTwo = restaurantModel.getAverageCostForTwo();
            String priceText = "$" + priceForTwo + " for two people(approx.)";
            viewModel.price.set(priceText);
            restaurantData.add(viewModel);
        }

        restaurantListAdapter.setData(restaurantData);
    }

    @Override
    public void onRestaurantSelect(int id) {
        Intent intent = new Intent(context, RestaurantActivity.class);
        intent.putExtra(StaticValues.EXTRA_REST_ID, id);
        startActivity(intent);
    }

    @Override
    public void onCollectionSelect(int id, String image) {
        Intent intent = new Intent(context, CollectionActivity.class);
        intent.putExtra(StaticValues.EXTRA_COLLECTION_ID, id);
        intent.putExtra(StaticValues.EXTRA_CITY_ID, cityId);
        intent.putExtra(StaticValues.EXTRA_COLLECTION_IMAGE, image);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCitySuccessEvent(OnCitySuccessEvent event) {
        if (event.getCategory() != categoryId) {
            return;
        }

        Log.d(TAG, "onCitySuccessEvent: ");
        CityModel cityModel = event.getCityModel();

        cityId = cityModel.getLocationSuggestions().get(0).getId();
        Location location = LocationHelper.getInstance().getCurrentLocation();

        mViewModel.retrieveCollections(cityId);
        mViewModel.getSearchResult(cityId, -1, categoryId, location);
    }
}
