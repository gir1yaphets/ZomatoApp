package com.example.zomatoapp.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;

import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.AllReviewsModel;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.dataModel.ReviewModel;
import com.example.zomatoapp.dataModel.UserReviewsModel;
import com.example.zomatoapp.databinding.ActivityRestaurantBinding;
import com.example.zomatoapp.eventbus.OnRestaurantsSuccessEvent;
import com.example.zomatoapp.eventbus.OnReviewSuccessEvent;
import com.example.zomatoapp.ui.HighlightListAdapter;
import com.example.zomatoapp.ui.ReviewListAdapter;
import com.example.zomatoapp.utils.StaticValues;
import com.example.zomatoapp.viewModel.HighlightItemViewModel;
import com.example.zomatoapp.viewModel.RestActivityViewModel;
import com.example.zomatoapp.viewModel.RestDetailViewModel;
import com.example.zomatoapp.viewModel.RestMenuViewModel;
import com.example.zomatoapp.viewModel.RestRatingViewModel;
import com.example.zomatoapp.viewModel.RestReviewViewModel;
import com.example.zomatoapp.viewModel.RestTitleViewModel;
import com.example.zomatoapp.viewModel.ReviewItemViewModel;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ActivityRestaurantBinding mBinding;
    private RestActivityViewModel mViewModel;

    private SupportMapFragment mapFragment;

    private RecyclerView highlightRecyclerView;
    private HighlightListAdapter highLightAdapter;

    private RatingReviews ratingReviews;
    private int[] raters = new int[5];

    private RecyclerView reviewRecyclerView;
    private ReviewListAdapter reviewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant);
        initView();
        initViewModel();

        mBinding.setViewModel(mViewModel);
        mBinding.setLifecycleOwner(this);
        EventBus.getDefault().register(this);

        int id = getIntent().getIntExtra(StaticValues.EXTRA_REST_ID, 0);
        mViewModel.retrieveSpecRestaurantInfo(id);
        mViewModel.fetchRestReviewInfo(id, 0, 1);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    }

    private void initView() {
        highlightRecyclerView = mBinding.llDetailLayout.rvHighlight;
        highlightRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        highLightAdapter = new HighlightListAdapter(new ArrayList<>());
        highlightRecyclerView.setAdapter(highLightAdapter);

        reviewRecyclerView = mBinding.llReviewLayout.rvReviewList;
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        reviewAdapter = new ReviewListAdapter(new ArrayList<>());
        reviewRecyclerView.setAdapter(reviewAdapter);

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
        mViewModel.restImageUrl.setValue(restaurantModel.getFeaturedImage());
        mViewModel.location.setValue(restaurantModel.getLocation());

        //Update restaurant title
        updateRestTitle(restaurantModel);

        //Update restaurant detail
        updateRestDetail(restaurantModel);

        //Update restaurant ratings
        updateRestRatings(restaurantModel);

        mapFragment.getMapAsync(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnReviewSuccessEvent(OnReviewSuccessEvent event) {
        AllReviewsModel allReviewsModel = event.getAllReviewsModel();
        updateRestReviews(allReviewsModel);
    }

    private void updateRestTitle(RestaurantModel restaurantModel) {
        mViewModel.titleViewModel.restName.setValue(restaurantModel.getName());
        mViewModel.titleViewModel.restDescrip.setValue(restaurantModel.getCuisines());
        mViewModel.titleViewModel.restAddress.setValue(restaurantModel.getLocation().getCity());
        mViewModel.titleViewModel.restRating.setValue(restaurantModel.getUserRating().getAggregateRating());
        mViewModel.titleViewModel.restReviewCount.setValue(restaurantModel.getAllReviewsCount() + " reviews");
    }

    private void updateRestDetail(RestaurantModel restaurantModel) {
        mViewModel.detailViewModel.cuisines.setValue(restaurantModel.getCuisines());
        mViewModel.detailViewModel.averageCost.setValue(restaurantModel.getAverageCostForTwo() + "$ for two people");

        for (String highlightInfo : restaurantModel.getHighlights()) {
            HighlightItemViewModel itemViewModel = new HighlightItemViewModel();
            itemViewModel.highlightName.setValue(highlightInfo);
            mViewModel.detailViewModel.addHighlightItem(itemViewModel);
        }

        List<HighlightItemViewModel> list =  mViewModel.detailViewModel.getHighlightItemViewModels();
        highLightAdapter.setData(list);
    }

    private void updateRestRatings(RestaurantModel restaurantModel) {
        mViewModel.ratingViewModel.score.setValue(restaurantModel.getUserRating().getAggregateRating());
        String reviewCount = restaurantModel.getAllReviewsCount() + " reviews";
        mViewModel.ratingViewModel.raters.setValue(reviewCount);
    }

    private void updateRestReviews(AllReviewsModel allReviewsModel) {
        RestReviewViewModel restReviewViewModel = mViewModel.reviewViewModel;

        for (UserReviewsModel userReviewsModel : allReviewsModel.getUserReviews()) {
            ReviewModel review = userReviewsModel.getReview();

            ReviewItemViewModel itemViewModel = new ReviewItemViewModel();
            itemViewModel.userName.set(review.getUser().getName());
            itemViewModel.userPhotoUrl.set(review.getUser().getProfileImage());
            itemViewModel.reviewTime.set(review.getReviewTimeFriendly());
            itemViewModel.comments.set(review.getReviewText());

            restReviewViewModel.addReview(itemViewModel);
        }

        reviewAdapter.setData(restReviewViewModel.getReviewItemViewModels());
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
