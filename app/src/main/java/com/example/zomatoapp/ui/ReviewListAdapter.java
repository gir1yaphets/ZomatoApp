package com.example.zomatoapp.ui;

import com.example.zomatoapp.R;
import com.example.zomatoapp.ui.common.CommonRecyclerAdapter;
import com.example.zomatoapp.viewModel.ReviewItemViewModel;

import java.util.List;

public class ReviewListAdapter extends CommonRecyclerAdapter<ReviewItemViewModel> {
    public ReviewListAdapter(List<ReviewItemViewModel> data) {
        super(data);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_review_item;
    }
}
