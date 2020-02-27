package com.example.zomatoapp.viewModel;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class RestReviewViewModel extends AndroidViewModel {
    public List<ReviewItemViewModel> getReviewItemViewModels() {
        return reviewItemViewModels;
    }

    private List<ReviewItemViewModel> reviewItemViewModels = new ArrayList<>();

    public RestReviewViewModel(@NonNull Application application) {
        super(application);
    }

    public void addReview(ReviewItemViewModel itemViewModel) {
        reviewItemViewModels.add(itemViewModel);
    }
}
