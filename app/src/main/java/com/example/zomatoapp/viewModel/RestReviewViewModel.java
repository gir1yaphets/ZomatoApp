package com.example.zomatoapp.viewModel;

import android.app.Application;

import com.example.zomatoapp.ui.ReviewListAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class RestReviewViewModel extends AndroidViewModel {
    public List<ReviewItemViewModel> getReviewItemViewModels() {
        return reviewItemViewModels;
    }

    private ReviewListAdapter reviewAdapter;
    private List<ReviewItemViewModel> reviewItemViewModels = new ArrayList<>();

    public RestReviewViewModel(@NonNull Application application) {
        super(application);

        reviewAdapter = new ReviewListAdapter(reviewItemViewModels);
    }

    public void addReview(ReviewItemViewModel itemViewModel) {
        reviewItemViewModels.add(itemViewModel);
    }

    public ReviewListAdapter getReviewAdapter() {
        return reviewAdapter;
    }

    public void refresh() {
        reviewAdapter.setData(reviewItemViewModels);
    }
}
