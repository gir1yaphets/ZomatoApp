package com.example.zomatoapp.viewModel;

import android.app.Application;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zomatoapp.R;
import com.example.zomatoapp.dataModel.AllReviewsModel;
import com.example.zomatoapp.dataModel.LocationModel;
import com.example.zomatoapp.dataModel.RestaurantModel;
import com.example.zomatoapp.dataModel.ReviewModel;
import com.example.zomatoapp.dataModel.UserReviewsModel;
import com.example.zomatoapp.helper.ZomatoDataHelper;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class RestActivityViewModel extends AndroidViewModel {
    private ZomatoDataHelper zomatoDataHelper;

    public MutableLiveData<String> restImageUrl = new MutableLiveData<>();
    public MutableLiveData<LocationModel> location = new MutableLiveData<>();

    public RestTitleViewModel titleViewModel;
    public RestMenuViewModel menuViewModel;
    public RestDetailViewModel detailViewModel;
    public RestRatingViewModel ratingViewModel;
    public RestReviewViewModel reviewViewModel;

    public RestActivityViewModel(@NonNull Application application) {
        super(application);
        zomatoDataHelper = new ZomatoDataHelper(application);
    }

    public void retrieveSpecRestaurantInfo(int id) {
        zomatoDataHelper.retrieveRestaurant(id);
    }

    public void fetchRestReviewInfo(int id, int start, int end) {
        zomatoDataHelper.getReviews(id, start, end);
    }

    @BindingAdapter({"restImageUrl"})
    public static void loadRestImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.banner_background)
                .into(imageView);
    }

    public void updateRestaurantInfo(RestaurantModel restaurantModel) {
        restImageUrl.setValue(restaurantModel.getFeaturedImage());
        location.setValue(restaurantModel.getLocation());

        //Update restaurant title
        updateRestTitle(restaurantModel);

        //Update restaurant detail
        updateRestDetail(restaurantModel);

        //Update restaurant ratings
        updateRestRatings(restaurantModel);
    }

    private void updateRestTitle(RestaurantModel restaurantModel) {
        titleViewModel.restName.setValue(restaurantModel.getName());
        titleViewModel.restDescrip.setValue(restaurantModel.getCuisines());
        titleViewModel.restAddress.setValue(restaurantModel.getLocation().getCity());
        titleViewModel.restRating.setValue(restaurantModel.getUserRating().getAggregateRating());
        titleViewModel.restReviewCount.setValue(restaurantModel.getAllReviewsCount() + " reviews");
    }

    private void updateRestDetail(RestaurantModel restaurantModel) {
        detailViewModel.cuisines.setValue(restaurantModel.getCuisines());
        detailViewModel.averageCost.setValue(restaurantModel.getAverageCostForTwo() + "$ for two people");

        for (String highlightInfo : restaurantModel.getHighlights()) {
            HighlightItemViewModel itemViewModel = new HighlightItemViewModel();
            itemViewModel.highlightName.setValue(highlightInfo);
            detailViewModel.addHighlightItem(itemViewModel);
        }

        detailViewModel.refresh();
    }

    private void updateRestRatings(RestaurantModel restaurantModel) {
        ratingViewModel.score.setValue(restaurantModel.getUserRating().getAggregateRating());
        String reviewCount = restaurantModel.getAllReviewsCount() + " reviews";
        ratingViewModel.raters.setValue(reviewCount);
    }

    public void updateRestReviews(AllReviewsModel allReviewsModel) {
        RestReviewViewModel restReviewViewModel = reviewViewModel;

        for (UserReviewsModel userReviewsModel : allReviewsModel.getUserReviews()) {
            ReviewModel review = userReviewsModel.getReview();

            ReviewItemViewModel itemViewModel = new ReviewItemViewModel();
            itemViewModel.userName.set(review.getUser().getName());
            itemViewModel.userPhotoUrl.set(review.getUser().getProfileImage());
            itemViewModel.reviewTime.set(review.getReviewTimeFriendly());
            itemViewModel.comments.set(review.getReviewText());
            itemViewModel.rating.set(Math.round(review.getRating()) + "★");
            itemViewModel.ratingColor.set(review.getRatingColor());
            itemViewModel.ratingText.set(review.getRatingText());

            reviewViewModel.addReview(itemViewModel);
        }

        restReviewViewModel.refresh();
    }
}
