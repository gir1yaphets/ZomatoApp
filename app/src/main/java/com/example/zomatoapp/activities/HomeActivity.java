package com.example.zomatoapp.activities;

import android.os.Bundle;

import com.example.zomatoapp.R;
import com.example.zomatoapp.databinding.ActivityHomeBinding;
import com.example.zomatoapp.viewModel.HomeViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mBinding;
    private HomeViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new HomeViewModel();
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        mBinding.setViewModel(mViewModel);
    }
}
