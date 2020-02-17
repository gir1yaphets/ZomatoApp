package com.example.zomatoapp.activities;

import android.os.Bundle;

import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.databinding.ActivityRestaurantBinding;
import com.example.zomatoapp.eventbus.OnRestaurantsSuccessEvent;
import com.example.zomatoapp.utils.StaticValues;
import com.example.zomatoapp.viewModel.RestActivityViewModel;
import com.example.zomatoapp.viewModel.RestTitleViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class RestaurantActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ActivityRestaurantBinding mBinding;
    private RestActivityViewModel mViewModel;

    private SupportMapFragment mapFragment;

    private static final LatLng SFO = new LatLng(37.614631, -122.385153);
    private static final LatLng SOH = new LatLng(-33.85704, 151.21522);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant);
        mViewModel = new ViewModelProvider(this).get(RestActivityViewModel.class);
        mViewModel.titleViewModel = new ViewModelProvider(this).get(RestTitleViewModel.class);

        mBinding.setViewModel(mViewModel);
        mBinding.setLifecycleOwner(this);
        EventBus.getDefault().register(this);

        int id = getIntent().getIntExtra(StaticValues.EXTRA_REST_ID, 0);
        mViewModel.retrieveSpecRestaurantInfo(id);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnRestaurantsSuccessEvent(OnRestaurantsSuccessEvent event) {
        RestaurantModel restaurantModel = event.getRestaurantModel();
        mViewModel.restImageUrl.setValue(restaurantModel.getFeaturedImage());
        mViewModel.location.setValue(restaurantModel.getLocation());
        mViewModel.titleViewModel.restName.setValue(restaurantModel.getName());
        mViewModel.titleViewModel.restDescrip.setValue(restaurantModel.getCuisines());
        mViewModel.titleViewModel.restAddress.setValue(restaurantModel.getLocation().getCity());
        mViewModel.titleViewModel.restRating.setValue(restaurantModel.getUserRating().getAggregateRating());
        mViewModel.titleViewModel.restReviewCount.setValue(restaurantModel.getAllReviewsCount() + " reviews");

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng;
        if (mViewModel.location.getValue() != null) {
            double lat = Double.parseDouble(mViewModel.location.getValue().getLatitude());
            double lon = Double.parseDouble(mViewModel.location.getValue().getLongitude());
            latLng = new LatLng(lat, lon);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
            googleMap.addMarker(new MarkerOptions().position(latLng).title(mViewModel.titleViewModel.restName.getValue()));
        }
    }
}
