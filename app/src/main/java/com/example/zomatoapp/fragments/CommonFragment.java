package com.example.zomatoapp.fragments;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.CityModel;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.dataModel.realmObject.DbSearchModel;
import com.example.zomatoapp.databinding.FragmentDiningLayoutBinding;
import com.example.zomatoapp.eventbus.OnCitySuccessEvent;
import com.example.zomatoapp.eventbus.OnCollectionsSuccessEvent;
import com.example.zomatoapp.eventbus.OnSearchSuccessEvent;
import com.example.zomatoapp.helper.LocationHelper;
import com.example.zomatoapp.viewModel.CommonViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class CommonFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = CommonFragment.class.getName();

    public static final String FRAGMENT_TYPE = "FRAGMENT_TYPE";

    public static final int DINING_FRAGMENT = 9;
    public static final int NIGHT_LIFE_FRAGMENT = 3;

    private FragmentDiningLayoutBinding mBinding;
    protected CommonViewModel mViewModel;

    private int categoryId;

    private Context context;

    private SwipeRefreshLayout swipeRefreshLayout;

    private RecyclerView rvCollectionsView;

    private RecyclerView rvRestaurantListView;

    private SkeletonScreen skeletonScreen;

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
        swipeRefreshLayout = mBinding.sflRefreshContainer;
        swipeRefreshLayout.setOnRefreshListener(this);

        rvCollectionsView = mBinding.rvCollectionList;
        rvCollectionsView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        rvCollectionsView.setAdapter(mViewModel.getCollectionAdapter());

        rvRestaurantListView = mBinding.rvRestaurantList;
        rvRestaurantListView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        rvRestaurantListView.setAdapter(mViewModel.getRestaurantListAdapter());

        skeletonScreen = Skeleton.bind(swipeRefreshLayout)
                .load(R.layout.activity_view_skeleton)
                .duration(1000)
                .color(R.color.shimmer_color)
                .angle(0)
                .show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCollectionsSuccessEvent(OnCollectionsSuccessEvent event) {
        if (event.getCollectionRequestModel().getCategoryId() != categoryId) return;

        CollectionListModel collectionListModel = event.getCollectionListModel();
        mViewModel.updateCollectionViewModel(collectionListModel);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRestaurantSearchSuccessEvent(OnSearchSuccessEvent event) {
        if (event.getSearchRequestModel().getCategoryId() != categoryId) return;
        Log.d(TAG, "onRestaurantSearchSuccessEvent: event.category = " + event.getSearchRequestModel().getCategoryId() + " curr category = " + categoryId);

        skeletonScreen.hide();
        DbSearchModel dbSearchModel = event.getDbSearchModel();

        mViewModel.updateRestaurantViewModel(dbSearchModel);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCitySuccessEvent(OnCitySuccessEvent event) {
        if (event.getCategory() != categoryId) {
            return;
        }

        Log.d(TAG, "onCitySuccessEvent: ");
        CityModel cityModel = event.getCityModel();

        int cityId = cityModel.getLocationSuggestions().get(0).getId();
        mViewModel.cityId.set(cityId);
        Location location = LocationHelper.getInstance().getCurrentLocation();

        mViewModel.retrieveCollections(cityId, categoryId, 8);
        mViewModel.getSearchResult(cityId, -1, categoryId, location);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(() -> {
                    swipeRefreshLayout.setRefreshing(false);
                },

                2000);
    }
}
