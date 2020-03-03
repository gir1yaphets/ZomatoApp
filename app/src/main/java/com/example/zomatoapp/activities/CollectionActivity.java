package com.example.zomatoapp.activities;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import com.example.zomatoapp.dataModel.CityModel;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.dataModel.RestaurantsModel;
import com.example.zomatoapp.dataModel.SearchModel;
import com.example.zomatoapp.databinding.ActivityCollectionBinding;
import com.example.zomatoapp.databinding.ActivityHomeBinding;
import com.example.zomatoapp.eventbus.OnCitySuccessEvent;
import com.example.zomatoapp.eventbus.OnSearchSuccessEvent;
import com.example.zomatoapp.fragments.DiningFragment;
import com.example.zomatoapp.fragments.NightLifeFragment;
import com.example.zomatoapp.fragments.ProfileFragment;
import com.example.zomatoapp.helper.LocationHelper;
import com.example.zomatoapp.utils.StaticValues;
import com.example.zomatoapp.viewModel.CollectionsViewModel;
import com.example.zomatoapp.viewModel.HomeViewModel;
import com.example.zomatoapp.viewModel.RestActivityViewModel;
import com.example.zomatoapp.viewModel.RestTitleViewModel;
import com.example.zomatoapp.viewModel.RestaurantItemViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;

import com.example.zomatoapp.R;
import com.google.android.material.tabs.TabLayout;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class CollectionActivity extends AppCompatActivity implements RestaurantItemViewModel.OnRestaurantSelectListener{
    private static final String TAG = CollectionActivity.class.getName();
    private ActivityCollectionBinding mBinding;
    private CollectionsViewModel mViewModel;
    private int collectionId;
    private List<RestaurantItemViewModel> restaurantData = new ArrayList<>();
    private NestedScrollView scrollView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_collection);
        mViewModel = new CollectionsViewModel(this);
        mBinding.setViewModel(mViewModel);
        collectionId = getIntent().getIntExtra(StaticValues.SearchApiKey.COLLECTION_ID_KEY, 1);

        EventBus.getDefault().register(this);

        fetchLocation();

    }

    private void initView() {
        scrollView = mBinding.clNestedScrollView;
        scrollView.setFillViewport(true);
    }

    private void fetchLocation() {
        RxPermissions rxPermissions = new RxPermissions(this);
        Disposable disposable = rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (granted) {
                        LocationHelper.getInstance().getRxLocation(CollectionActivity.this, (location, address) -> mViewModel.getCityInfo());
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCitySuccessEvent(OnCitySuccessEvent event) {
        CityModel cityModel = event.getCityModel();
        int cityId = cityModel.getLocationSuggestions().get(0).getId();

        mViewModel.retrieveCollections(cityId);
        mViewModel.getSearchResult(cityId, collectionId, LocationHelper.getInstance().getCurrentLocation());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSearchSuccessEvent(OnSearchSuccessEvent event) {
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
    }

    @Override
    public void onRestaurantSelect(int id) {
        Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
        intent.putExtra(StaticValues.EXTRA_REST_ID, id);
        startActivity(intent);
    }
}
