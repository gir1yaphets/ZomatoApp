package com.example.zomatoapp.activities;

import android.content.Intent;
import android.os.Bundle;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.realmObject.DbRestaurantModel;
import com.example.zomatoapp.dataModel.realmObject.DbRestaurantsModel;
import com.example.zomatoapp.dataModel.realmObject.DbSearchModel;
import com.example.zomatoapp.databinding.ActivityCollectionBinding;
import com.example.zomatoapp.eventbus.OnSearchSuccessEvent;
import com.example.zomatoapp.helper.LocationHelper;
import com.example.zomatoapp.utils.StaticValues;
import com.example.zomatoapp.viewModel.CollectionsViewModel;
import com.example.zomatoapp.viewModel.RestaurantItemViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.zomatoapp.utils.StaticValues.EXTRA_COLLECTION_IMAGE;

public class CollectionActivity extends AppCompatActivity implements RestaurantItemViewModel.OnRestaurantSelectListener{
    private static final String TAG = CollectionActivity.class.getName();

    private ActivityCollectionBinding mBinding;
    private CollectionsViewModel mViewModel;

    private int cityId;
    private int collectionId;

    private CoordinatorLayout clRootView;
    private RecyclerView rvRestaurantList;
    private NestedScrollView scrollView;
    private SkeletonScreen skeletonScreen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_collection);

        mViewModel = new ViewModelProvider(this).get(CollectionsViewModel.class);
        mBinding.setCollectionViewModel(mViewModel);

        initData();
        initView();

        EventBus.getDefault().register(this);
    }

    private void initData() {
        Intent intent = getIntent();
        cityId = intent.getIntExtra(StaticValues.EXTRA_CITY_ID, 0);
        collectionId = intent.getIntExtra(StaticValues.EXTRA_COLLECTION_ID, 0);
        String collectionImage = intent.getStringExtra(EXTRA_COLLECTION_IMAGE);

        mViewModel.collectionImage.setValue(collectionImage);
        mViewModel.retrieveRestaurantsInCollection(cityId, collectionId, -1, LocationHelper.getInstance().getCurrentLocation());
    }

    private void initView() {
        clRootView = mBinding.clRootView;
        scrollView = mBinding.clNestedScrollView;
        scrollView.setFillViewport(true);

        rvRestaurantList = mBinding.rvRestaurantList;
        rvRestaurantList.setLayoutManager(new LinearLayoutManager(this));
        rvRestaurantList.setAdapter(mViewModel.getRestAdapter());

        skeletonScreen = Skeleton.bind(clRootView)
                .load(R.layout.activity_view_skeleton)
                .duration(1000)
                .color(R.color.shimmer_color)
                .angle(0)
                .show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSearchSuccessEvent(OnSearchSuccessEvent event) {
        if (event.getSearchRequestModel().getCategoryId() != -1) return;

        skeletonScreen.hide();

        DbSearchModel dbSearchModel = event.getDbSearchModel();
        for (DbRestaurantsModel restaurantsModel : dbSearchModel.getRestaurants()) {
            DbRestaurantModel restaurantModel = restaurantsModel.getRestaurant();
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

            mViewModel.addRestItem(viewModel);
        }

        mViewModel.refresh();
    }

    @Override
    public void onRestaurantSelect(int id) {
        Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
        intent.putExtra(StaticValues.EXTRA_REST_ID, id);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}
