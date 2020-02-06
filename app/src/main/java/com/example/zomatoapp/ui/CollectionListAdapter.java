package com.example.zomatoapp.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.zomatoapp.R;
import com.example.zomatoapp.databinding.LayoutItemCollectionBinding;
import com.example.zomatoapp.viewModel.CollectionItemViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CollectionListAdapter extends RecyclerView.Adapter<CollectionItemViewHolder> {

    private LayoutItemCollectionBinding mBinding;
    private List<CollectionItemViewModel> data;

    public CollectionListAdapter(List<CollectionItemViewModel> data) {
        this.data = data;
    }

    public void addData(CollectionItemViewModel viewModel) {
        data.add(viewModel);
    }

    public void setData(List<CollectionItemViewModel> data) {
        this.data = data;
    }

    public List<CollectionItemViewModel> getData() {
        return data;
    }

    @NonNull
    @Override
    public CollectionItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_item_collection, parent, false);
        return new CollectionItemViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionItemViewHolder holder, int position) {
        mBinding.setViewModel(data.get(position));
        mBinding.executePendingBindings();
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
