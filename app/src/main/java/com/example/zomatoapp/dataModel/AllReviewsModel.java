package com.example.zomatoapp.dataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllReviewsModel {
    @SerializedName("reviews")
    private List<ReviewsModel> reviews;

    public List<ReviewsModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewsModel> reviews) {
        this.reviews = reviews;
    }

    public static class ReviewsModel {
        @SerializedName("review")
        private List<?> review;

        public List<?> getReview() {
            return review;
        }

        public void setReview(List<?> review) {
            this.review = review;
        }
    }
}
