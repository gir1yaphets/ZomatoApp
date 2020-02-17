package com.example.zomatoapp.activities;

import android.os.Bundle;

import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.databinding.ActivityRestaurantBinding;
import com.example.zomatoapp.eventbus.OnRestaurantsSuccessEvent;
import com.example.zomatoapp.utils.StaticValues;
import com.example.zomatoapp.viewModel.RestActivityViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class RestaurantActivity extends AppCompatActivity {
    private ActivityRestaurantBinding mBinding;
    private RestActivityViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant);
        mViewModel = new ViewModelProvider(this).get(RestActivityViewModel.class);
        mBinding.setViewModel(mViewModel);

        EventBus.getDefault().register(this);

        int id = getIntent().getIntExtra(StaticValues.EXTRA_REST_ID, 0);
        mViewModel.retrieveSpecRestaurantInfo(id);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnRestaurantsSuccessEvent (OnRestaurantsSuccessEvent event) {
        RestaurantModel restaurantModel = event.getRestaurantModel();
        mViewModel.imageUrl.setValue(restaurantModel.getFeaturedImage());
//        mViewModel.imageUrl2.set(restaurantModel.getFeaturedImage());
    }
}
