package com.example.zomatoapp.viewModel;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class RestaurantItemViewModel {
    public ObservableField<String> name = new ObservableField<>();

    public ObservableField<String> rating = new ObservableField<>();

    public ObservableField<String> description = new ObservableField<>();

    public ObservableField<String> status = new ObservableField<>();

    public ObservableField<String> location = new ObservableField<>();

    public ObservableField<String> price = new ObservableField<>();

    public ObservableField<String> imageUrl = new ObservableField<>();

    @BindingAdapter({"restaurantImageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
//                .placeholder(holderDrawable)
                .into(imageView);
    }
}
