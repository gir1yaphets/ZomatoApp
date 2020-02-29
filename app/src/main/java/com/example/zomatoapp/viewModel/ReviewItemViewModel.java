package com.example.zomatoapp.viewModel;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class ReviewItemViewModel {
    public ObservableField<String> userPhotoUrl = new ObservableField<>();

    public ObservableField<String> userName = new ObservableField<>();

    public ObservableField<String> reviewAndFollow = new ObservableField<>();

    public ObservableField<String> score = new ObservableField<>();

    public ObservableField<String> reviewTime = new ObservableField<>();

    public ObservableField<String> reviewFeatures1 = new ObservableField<>();

    public ObservableField<String> reviewFeatures2 = new ObservableField<>();

    public ObservableField<String> comments = new ObservableField<>();

    @BindingAdapter({"userPhotoUrl"})
    public static void loadRestImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
