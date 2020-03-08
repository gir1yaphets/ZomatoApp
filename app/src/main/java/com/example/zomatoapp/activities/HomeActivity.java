package com.example.zomatoapp.activities;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;

import com.example.zomatoapp.R;
import com.example.zomatoapp.databinding.ActivityHomeBinding;
import com.example.zomatoapp.fragments.CommonFragment;
import com.example.zomatoapp.fragments.ProfileFragment;
import com.example.zomatoapp.viewModel.HomeViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import io.reactivex.disposables.Disposable;

public class HomeActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = HomeActivity.class.getName();
    private ActivityHomeBinding mBinding;
    private HomeViewModel mViewModel;

    private SwipeRefreshLayout swipeRefreshLayout;
    private NestedScrollView scrollView;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    private List<String> labels = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    private static final String LABEL_DINING = "Dining";
    private static final String LABEL_NIGHT_LEFT = "Nightlife";
    private static final String LABEL_PROFILE = "Profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new HomeViewModel(this);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        mBinding.setViewModel(mViewModel);

        initView();
        fetchLocation();
    }

    private void initView() {
        swipeRefreshLayout = mBinding.sflRefreshContainer;
        swipeRefreshLayout.setOnRefreshListener(this);

        scrollView = mBinding.nsvScrollView;
        viewPager = mBinding.vpFragmentViewPager;
        tabLayout = mBinding.tlTabLayout;

        scrollView.setFillViewport(true);

        fragments.add(CommonFragment.newInstance(CommonFragment.DINING_FRAGMENT));
        fragments.add(CommonFragment.newInstance(CommonFragment.NIGHT_LIFE_FRAGMENT));
        fragments.add(ProfileFragment.newInstance());

        initViewPager();
        initIndicator();
    }

    private void initViewPager() {
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragments.get(position);
            }

            @Override
            public int getItemCount() {
                return fragments.size();
            }
        });

        viewPager.setUserInputEnabled(false);
        viewPager.setOffscreenPageLimit(2);
    }

    private void initIndicator() {
        labels.add(LABEL_DINING);
        labels.add(LABEL_NIGHT_LEFT);
        labels.add(LABEL_PROFILE);

        new TabLayoutMediator(tabLayout, viewPager, true, (tab, position) -> tab.setText(labels.get(position))).attach();
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

    @Override
    public void onRefresh() {
        //Todo: dummy process
        new Handler().postDelayed(() -> swipeRefreshLayout.setRefreshing(false), 2000);
    }
}
