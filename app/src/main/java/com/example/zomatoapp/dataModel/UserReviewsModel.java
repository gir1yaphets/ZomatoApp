package com.example.zomatoapp.dataModel;

import com.google.gson.annotations.SerializedName;

public class UserReviewsModel {
    /**
     * review : {"rating":5,"review_text":"","id":45706756,"rating_color":"305D02",
     * "review_time_friendly":"4 months ago","rating_text":"Insane!","timestamp":1571476136,
     * "likes":0,"user":{"name":"Siddharth Sharma","foodie_level":"Super Foodie",
     * "foodie_level_num":9,"foodie_color":"f58552","profile_url":"https://www.zomato
     * .com/users/siddharth-sharma-144912900?utm_source=api_basic_user&utm_medium=api
     * &utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/images/user_avatars/mug_2x
     * .png?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
     * "profile_deeplink":"zomato://u/144912900"},"comments_count":0}
     */

    @SerializedName("review")
    private ReviewModel review;

    public ReviewModel getReview() {
        return review;
    }

    public void setReview(ReviewModel review) {
        this.review = review;
    }
}
