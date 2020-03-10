package com.example.zomatoapp.ui;

import com.example.zomatoapp.R;
import com.example.zomatoapp.ui.common.CommonRecyclerAdapter;
import com.example.zomatoapp.viewModel.CollectionItemViewModel;

import java.util.List;

public class CollectionDetailAdapter extends CommonRecyclerAdapter<CollectionItemViewModel> {
    public CollectionDetailAdapter(List<CollectionItemViewModel> data) {
        super(data);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_item_collection_detail;
    }
}
