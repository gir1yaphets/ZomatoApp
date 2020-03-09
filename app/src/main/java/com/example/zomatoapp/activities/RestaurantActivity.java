package com.example.zomatoapp.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;

import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.AllReviewsModel;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.databinding.ActivityRestaurantBinding;
import com.example.zomatoapp.eventbus.OnRestaurantsSuccessEvent;
import com.example.zomatoapp.eventbus.OnReviewSuccessEvent;
import com.example.zomatoapp.utils.StaticValues;
import com.example.zomatoapp.viewModel.RestActivityViewModel;
import com.example.zomatoapp.viewModel.RestDetailViewModel;
import com.example.zomatoapp.viewModel.RestMenuViewModel;
import com.example.zomatoapp.viewModel.RestRatingViewModel;
import com.example.zomatoapp.viewModel.RestReviewViewModel;
import com.example.zomatoapp.viewModel.RestTitleViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.taufiqrahman.reviewratings.BarLabels;
import com.taufiqrahman.reviewratings.RatingReviews;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = RestaurantActivity.class.getName();
    
    private ActivityRestaurantBinding mBinding;
    private RestActivityViewModel mViewModel;

    private SupportMapFragment mapFragment;

    private RecyclerView highlightRecyclerView;

    private RatingReviews ratingReviews;
    private int[] raters = new int[5];

    private RecyclerView reviewRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant);
        initViewModel();
        initView();

        mBinding.setViewModel(mViewModel);
        mBinding.setLifecycleOwner(this);
        EventBus.getDefault().register(this);

        int id = getIntent().getIntExtra(StaticValues.EXTRA_REST_ID, 0);
        mViewModel.retrieveSpecRestaurantInfo(id);
        mViewModel.fetchRestReviewInfo(id, 0, 10);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    }

    private void initView() {
        highlightRecyclerView = mBinding.llDetailLayout.rvHighlight;
        highlightRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        highlightRecyclerView.setAdapter(mViewModel.detailViewModel.getHighLightAdapter());

        reviewRecyclerView = mBinding.llReviewLayout.rvReviewList;
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        reviewRecyclerView.setAdapter(mViewModel.reviewViewModel.getReviewAdapter());

        configureRating();
    }

    private void configureRating() {
        ratingReviews = mBinding.llRatingLayout.ratingReviews;
        Pair colors[] = new Pair[]{
                new Pair<>(Color.parseColor("#0e9d58"), Color.parseColor("#1e88e5")),
                new Pair<>(Color.parseColor("#bfd047"), Color.parseColor("#5c6bc0")),
                new Pair<>(Color.parseColor("#ffc105"), Color.parseColor("#d81b60")),
                new Pair<>(Color.parseColor("#ef7e14"), Color.parseColor("#8bc34a")),
                new Pair<>(Color.parseColor("#d36259"), Color.parseColor("#ea80fc"))
        };

        int minValue = 30;

        for (int i = 0; i < 5; i++) {
            raters[i] = minValue + new Random().nextInt(100 - minValue + 1);
        }

        ratingReviews.createRatingBars(100, BarLabels.STYPE1, colors, raters);
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(RestActivityViewModel.class);
        mViewModel.titleViewModel = new ViewModelProvider(this).get(RestTitleViewModel.class);
        mViewModel.menuViewModel = new ViewModelProvider(this).get(RestMenuViewModel.class);
        mViewModel.detailViewModel = new ViewModelProvider(this).get(RestDetailViewModel.class);
        mViewModel.ratingViewModel = new ViewModelProvider(this).get(RestRatingViewModel.class);
        mViewModel.reviewViewModel = new ViewModelProvider(this).get(RestReviewViewModel.class);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnRestaurantsSuccessEvent(OnRestaurantsSuccessEvent event) {
        RestaurantModel restaurantModel = event.getRestaurantModel();

        mViewModel.updateRestaurantInfo(restaurantModel);
        mapFragment.getMapAsync(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnReviewSuccessEvent(OnReviewSuccessEvent event) {
        AllReviewsModel allReviewsModel = event.getAllReviewsModel();
        mViewModel.updateRestReviews(allReviewsModel);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        
        EventBus.getDefault().unregister(this);
    }
}
