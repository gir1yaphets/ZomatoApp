package com.example.zomatoapp.viewModel;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class CollectionItemViewModel {
    public interface OnCollectionSelectListener {
        void onCollectionSelect(int id);
    }

    public ObservableField<String> collectionTitle = new ObservableField<>();

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
                .into(imageView);
    }

    public void onItemSelected(View view) {
        if (listener != null) {
            listener.onCollectionSelect(id);
        }
    }


}
