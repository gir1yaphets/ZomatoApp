package com.example.zomatoapp.dataModel;

import com.google.gson.annotations.SerializedName;

public class ReviewModel {
    /**
     * rating : 5
     * review_text :
     * id : 45706756
     * rating_color : 305D02
     * review_time_friendly : 4 months ago
     * rating_text : Insane!
     * timestamp : 1571476136
     * likes : 0
     * user : {"name":"Siddharth Sharma","foodie_level":"Super Foodie","foodie_level_num":9,
     * "foodie_color":"f58552","profile_url":"https://www.zomato
     * .com/users/siddharth-sharma-144912900?utm_source=api_basic_user&utm_medium=api
     * &utm_campaign=v2.1","profile_image":"https://b.zmtcdn.com/images/user_avatars/mug_2x
     * .png?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
     * "profile_deeplink":"zomato://u/144912900"}
     * comments_count : 0
     */

    @SerializedName("rating")
    private float rating;
    @SerializedName("review_text")
    private String reviewText;
    @SerializedName("id")
    private int id;
    @SerializedName("rating_color")
    private String ratingColor;
    @SerializedName("review_time_friendly")
    private String reviewTimeFriendly;
    @SerializedName("rating_text")
    private String ratingText;
    @SerializedName("timestamp")
    private int timestamp;
    @SerializedName("likes")
    private int likes;
    @SerializedName("user")
    private UserModel user;
    @SerializedName("comments_count")
    private int commentsCount;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public String getReviewTimeFriendly() {
        return reviewTimeFriendly;
    }

    public void setReviewTimeFriendly(String reviewTimeFriendly) {
        this.reviewTimeFriendly = reviewTimeFriendly;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }
}
