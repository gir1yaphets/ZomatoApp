package com.example.zomatoapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.dataModel.SearchModel;
import com.example.zomatoapp.databinding.FragmentDiningLayoutBinding;
import com.example.zomatoapp.eventbus.OnCollectionsSuccessEvent;
import com.example.zomatoapp.eventbus.OnSearchSuccessEvent;
import com.example.zomatoapp.ui.CollectionListAdapter;
import com.example.zomatoapp.ui.RestaurantListAdapter;
import com.example.zomatoapp.viewModel.CollectionItemViewModel;
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

public class DiningFragment extends Fragment {
    private static final String TAG = DiningFragment.class.getName();

    private FragmentDiningLayoutBinding mBinding;

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

    public static DiningFragment newInstance() {
        return new DiningFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dining_layout, container, false);
        context = getActivity();
        initView();
        EventBus.getDefault().register(this);
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
            Log.d(TAG, "onCollectionsSuccessEvent: description = " + collectionModel.getCollection().getDescription());

            CollectionItemViewModel viewModel = new CollectionItemViewModel();
            viewModel.collectionTitle.set(collectionModel.getCollection().getTitle());
            viewModel.imageUrl.set(collectionModel.getCollection().getImage_url());
            collectionData.add(viewModel);
        }

        collectionAdapter.setData(collectionData);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRestaurantSearchSuccessEvent(OnSearchSuccessEvent event) {
        SearchModel restaurantModel = event.getSearchModel();
        for (SearchModel.RestaurantsBean restaurantsBean : restaurantModel.getRestaurants()) {
            SearchModel.RestaurantsBean.RestaurantBean restaurantBean = restaurantsBean.getRestaurant();
            RestaurantItemViewModel viewModel = new RestaurantItemViewModel();
            viewModel.name.set(restaurantBean.getName());
            viewModel.description.set(restaurantBean.getCuisines());
            viewModel.status.set(restaurantBean.getTimings());
            viewModel.location.set(restaurantBean.getLocation().getCity());
            viewModel.imageUrl.set(restaurantBean.getThumb());
            viewModel.rating.set(restaurantBean.getUser_rating().getAggregate_rating());
            int priceForTwo = restaurantBean.getAverage_cost_for_two();
            String priceText = "$" + priceForTwo + " for two people(approx.)";
            viewModel.price.set(priceText);
            restaurantData.add(viewModel);
        }

        restaurantListAdapter.setData(restaurantData);
    }
}
