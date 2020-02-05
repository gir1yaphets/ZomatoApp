package com.example.zomatoapp.activities;

import android.os.Bundle;
import android.util.Log;

import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.databinding.ActivityHomeBinding;
import com.example.zomatoapp.eventbus.OnCollectionsSuccessEvent;
import com.example.zomatoapp.viewModel.HomeViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getName();
    private ActivityHomeBinding mBinding;
    private HomeViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new HomeViewModel(this);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        mBinding.setViewModel(mViewModel);

        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCollectionsSuccessEvent(OnCollectionsSuccessEvent event) {
        CollectionListModel collectionListModel = event.getCollectionListModel();
        for (CollectionListModel.Collections collectionModel : collectionListModel.getCollections()) {
            Log.d(TAG, "onCollectionsSuccessEvent: description = " + collectionModel.getCollection().getDescription());
        }
    }
}
