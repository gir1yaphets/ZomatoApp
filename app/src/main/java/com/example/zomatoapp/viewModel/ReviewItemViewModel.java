package com.example.zomatoapp.viewModel;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zomatoapp.R;
import com.example.zomatoapp.ZomatoApplication;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class ReviewItemViewModel {
    public ObservableField<String> userPhotoUrl = new ObservableField<>();

    public ObservableField<String> userName = new ObservableField<>();

    public ObservableField<String> reviewAndFollow = new ObservableField<>();

    public ObservableField<String> rating = new ObservableField<>();

    public ObservableField<String> reviewTime = new ObservableField<>();

    public ObservableField<String> reviewFeatures1 = new ObservableField<>();

    public ObservableField<String> reviewFeatures2 = new ObservableField<>();

    public ObservableField<String> comments = new ObservableField<>();

    public ObservableField<String> ratingColor = new ObservableField<>();

    public ObservableField<String> ratingText = new ObservableField<>();

    @BindingAdapter({"userPhotoUrl"})
    public static void loadRestImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    public Drawable getRatingBackground(int num) {
        return Character.getNumericValue(rating.get().charAt(0)) >= num ?
                ZomatoApplication.getContext().getDrawable(R.drawable.round_corner_rect) : ZomatoApplication.getContext().getDrawable(R.drawable.round_corner_rect_transparent);
    }
}
