package com.example.zomatoapp.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.zomatoapp.R;
import com.example.zomatoapp.databinding.LayoutItemRestaurantBinding;
import com.example.zomatoapp.viewModel.RestaurantItemViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantItemViewHolder> {
    private LayoutItemRestaurantBinding mBinding;
    private List<RestaurantItemViewModel> data;

    public RestaurantListAdapter(List<RestaurantItemViewModel> data) {
        this.data = data;
    }

    public void addData(RestaurantItemViewModel viewModel) {
        data.add(viewModel);
    }

    public void setData(List<RestaurantItemViewModel> data) {
        this.data = data;
    }

    public List<RestaurantItemViewModel> getData() {
        return data;
    }

    @NonNull
    @Override
    public RestaurantItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_item_restaurant, parent, false);
        return new RestaurantItemViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantItemViewHolder holder, int position) {
        mBinding.setViewModel(data.get(position));
        mBinding.executePendingBindings();
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
