package com.example.zomatoapp.viewModel;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zomatoapp.R;

import java.io.Serializable;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class CollectionItemViewModel implements Serializable {

    public interface OnCollectionSelectListener {
        void onCollectionSelect(int id, String image);
    }

    public ObservableField<String> collectionTitle = new ObservableField<>();

    public ObservableField<String> description = new ObservableField<>();

    public ObservableField<String> restCount = new ObservableField<>();

    public ObservableField<String> imageUrl = new ObservableField<>();

    private OnCollectionSelectListener listener;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListener(OnCollectionSelectListener listener) {
        this.listener = listener;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.place_holder)
                .into(imageView);
    }

    public void onItemSelected(View view) {
        if (listener != null) {
            listener.onCollectionSelect(id, imageUrl.get());
        }
    }


}
