package com.example.zomatoapp.dataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllReviewsModel {
    /**
     * reviews_count : 96
     * reviews_start : 0
     * reviews_shown : 2
     * user_reviews : [{"review":{"rating":5,"review_text":"","id":45706756,
     * "rating_color":"305D02","review_time_friendly":"4 months ago","rating_text":"Insane!",
     * "timestamp":1571476136,"likes":0,"user":{"name":"Siddharth Sharma","foodie_level":"Super
     * Foodie","foodie_level_num":9,"foodie_color":"f58552","profile_url":"https://www.zomato
     * .com/users/siddharth-sharma-144912900?utm_source=api_basic_user&utm_medium=api
     * &utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/images/user_avatars/mug_2x
     * .png?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
     * "profile_deeplink":"zomato://u/144912900"},"comments_count":0}},{"review":{"rating":4,
     * "review_text":"","id":45689448,"rating_color":"5BA829","review_time_friendly":"4 months
     * ago","rating_text":"Great!","timestamp":1571391100,"likes":0,"user":{"name":"Jennifer
     * Kinleiy","foodie_level":"Super Foodie","foodie_level_num":10,"foodie_color":"f58552",
     * "profile_url":"https://www.zomato
     * .com/users/jennifer-kinleiy-144763426?utm_source=api_basic_user&utm_medium=api
     * &utm_campaign=v2.1","profile_image":"https://b.zmtcdn
     * .com/data/user_profile_pictures/484/cee2d5f7654008df694851492f668484
     * .jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A",
     * "profile_deeplink":"zomato://u/144763426"},"comments_count":0}}]
     */

    @SerializedName("reviews_count")
    private int reviewsCount;
    @SerializedName("reviews_start")
    private int reviewsStart;
    @SerializedName("reviews_shown")
    private int reviewsShown;
    @SerializedName("user_reviews")
    private List<UserReviewsModel> userReviews;

    public int getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public int getReviewsStart() {
        return reviewsStart;
    }

    public void setReviewsStart(int reviewsStart) {
        this.reviewsStart = reviewsStart;
    }

    public int getReviewsShown() {
        return reviewsShown;
    }

    public void setReviewsShown(int reviewsShown) {
        this.reviewsShown = reviewsShown;
    }

    public List<UserReviewsModel> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(List<UserReviewsModel> userReviews) {
        this.userReviews = userReviews;
    }
}
