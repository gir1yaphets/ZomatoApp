package com.example.zomatoapp.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.CollectionListModel;
import com.example.zomatoapp.databinding.ActivityCollectionListBinding;
import com.example.zomatoapp.ui.CollectionDetailAdapter;
import com.example.zomatoapp.utils.StaticValues;
import com.example.zomatoapp.viewModel.CollectionItemViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CollectionListActivity extends AppCompatActivity implements CollectionItemViewModel.OnCollectionSelectListener {
    private static final String TAG = CollectionListActivity.class.getName();

    private ActivityCollectionListBinding mBinding;
    private List<CollectionItemViewModel> collectionList = new ArrayList<>();
    private RecyclerView rvCollectionListView;
    private CollectionDetailAdapter adapter;

    private CollectionListModel collectionListModel;
    private int cityId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_collection_list);

        initData();
        initView();
    }

    private void initData() {
        Intent intent = getIntent();
        collectionListModel = (CollectionListModel) intent.getSerializableExtra(StaticValues.EXTRA_COLLECTION_LIST);
        cityId = intent.getIntExtra(StaticValues.EXTRA_CITY_ID, 0);

        updateCollectionViewModel();
    }

    private void initView() {
        rvCollectionListView = mBinding.rvCollectionList;
        rvCollectionListView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CollectionDetailAdapter(collectionList);
        rvCollectionListView.setAdapter(adapter);
    }

    public void updateCollectionViewModel() {
        for (CollectionListModel.Collections collectionModel : collectionListModel.getCollections()) {
            CollectionItemViewModel viewModel = new CollectionItemViewModel();
            viewModel.setId(collectionModel.getCollection().getCollectionId());
            viewModel.collectionTitle.set(collectionModel.getCollection().getTitle());
            viewModel.imageUrl.set(collectionModel.getCollection().getImageUrl());
            viewModel.description.set(collectionModel.getCollection().getDescription());
            viewModel.restCount.set(collectionModel.getCollection().getResCount() + "PLACES");
            viewModel.setListener(this);
            collectionList.add(viewModel);
        }
    }

    @Override
    public void onCollectionSelect(int id, String image) {
        Intent intent = new Intent(this, CollectionActivity.class);
        intent.putExtra(StaticValues.EXTRA_COLLECTION_ID, id);
        intent.putExtra(StaticValues.EXTRA_CITY_ID, cityId);
        intent.putExtra(StaticValues.EXTRA_COLLECTION_IMAGE, image);
        startActivity(intent);
    }
}
