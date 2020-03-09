package com.example.zomatoapp.activities;

import android.Manifest;
import android.os.Bundle;

import com.example.zomatoapp.R;
import com.example.zomatoapp.databinding.ActivityLoginBinding;
import com.example.zomatoapp.viewModel.LoginViewModel;
import com.tbruyelle.rxpermissions2.RxPermissions;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding mBinding;
    private LoginViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        mBinding.setViewModel(mViewModel);
        initView();
    }

    private void initView() {
        fetchLocation();
    }

    private void fetchLocation() {
        RxPermissions rxPermissions = new RxPermissions(this);
        Disposable disposable = rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (!granted) {
                        finish();
                    }
                });
    }
}
