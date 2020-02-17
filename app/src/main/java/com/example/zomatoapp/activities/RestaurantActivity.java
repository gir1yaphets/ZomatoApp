package com.example.zomatoapp.activities;

import android.os.Bundle;

import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.databinding.ActivityRestaurantBinding;
import com.example.zomatoapp.eventbus.OnRestaurantsSuccessEvent;
import com.example.zomatoapp.utils.StaticValues;
import com.example.zomatoapp.viewModel.RestActivityViewModel;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant);
        mViewModel = new ViewModelProvider(this).get(RestActivityViewModel.class);

        mBinding.setViewModel(mViewModel);
        mBinding.setLifecycleOwner(this);
        EventBus.getDefault().register(this);

        int id = getIntent().getIntExtra(StaticValues.EXTRA_REST_ID, 0);
        mViewModel.retrieveSpecRestaurantInfo(id);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnRestaurantsSuccessEvent (OnRestaurantsSuccessEvent event) {
        RestaurantModel restaurantModel = event.getRestaurantModel();
        mViewModel.restImageUrl.setValue(restaurantModel.getFeaturedImage());
//        mViewModel.addressImageUrl.setValue(restaurantModel.);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
