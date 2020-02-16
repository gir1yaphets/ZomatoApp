package com.example.zomatoapp.activities;

import android.os.Bundle;

import com.example.zomatoapp.R;
import com.example.zomatoapp.databinding.ActivityRestaurantBinding;
import com.example.zomatoapp.viewModel.RestActivityViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class RestaurantActivity extends AppCompatActivity {
    private ActivityRestaurantBinding mBinding;
    private RestActivityViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant);
        mViewModel = new RestActivityViewModel();
        mBinding.setViewModel(mViewModel);
    }
}