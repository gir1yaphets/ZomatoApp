package com.example.zomatoapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.databinding.FragmentDiningLayoutBinding;
import com.example.zomatoapp.eventbus.OnCollectionsSuccessEvent;
import com.example.zomatoapp.ui.CollectionListAdapter;
import com.example.zomatoapp.viewModel.CollectionItemViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DiningFragment extends Fragment {
    private static final String TAG = DiningFragment.class.getName();

    private FragmentDiningLayoutBinding mBinding;

    private Context context;
    private RecyclerView rvCollectionsView;
    private CollectionListAdapter adapter;

    public List<CollectionItemViewModel> getData() {
        return data;
    }

    public void setData(List<CollectionItemViewModel> data) {
        this.data = data;
    }

    private List<CollectionItemViewModel> data = new ArrayList<>();

    public static DiningFragment newInstance() {
        return new DiningFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dining_layout, container, false);
        context = getActivity();
        initView();
        EventBus.getDefault().register(this);
        return mBinding.getRoot();
    }

    private void initView() {
        rvCollectionsView = mBinding.rvCollectionList;
        adapter = new CollectionListAdapter(data);

        rvCollectionsView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        rvCollectionsView.setAdapter(adapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCollectionsSuccessEvent(OnCollectionsSuccessEvent event) {
        CollectionListModel collectionListModel = event.getCollectionListModel();
        for (CollectionListModel.Collections collectionModel : collectionListModel.getCollections()) {
            Log.d(TAG, "onCollectionsSuccessEvent: description = " + collectionModel.getCollection().getDescription());

            CollectionItemViewModel viewModel = new CollectionItemViewModel();
            viewModel.collectionTitle.set(collectionModel.getCollection().getTitle());
            viewModel.imageUrl.set(collectionModel.getCollection().getImage_url());
            data.add(viewModel);
        }

        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
