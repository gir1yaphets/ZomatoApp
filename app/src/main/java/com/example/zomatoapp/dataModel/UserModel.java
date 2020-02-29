package com.example.zomatoapp.dataModel;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    /**
     * name : Siddharth Sharma
     * foodie_level : Super Foodie
     * foodie_level_num : 9
     * foodie_color : f58552
     * profile_url : https://www.zomato
     * .com/users/siddharth-sharma-144912900?utm_source=api_basic_user&utm_medium=api
     * &utm_campaign=v2.1
     * profile_image : https://b.zmtcdn.com/images/user_avatars/mug_2x
     * .png?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A
     * profile_deeplink : zomato://u/144912900
     */

    @SerializedName("name")
    private String name;
    @SerializedName("foodie_level")
    private String foodieLevel;
    @SerializedName("foodie_level_num")
    private int foodieLevelNum;
    @SerializedName("foodie_color")
    private String foodieColor;
    @SerializedName("profile_url")
    private String profileUrl;
    @SerializedName("profile_image")
    private String profileImage;
    @SerializedName("profile_deeplink")
    private String profileDeeplink;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodieLevel() {
        return foodieLevel;
    }

    public void setFoodieLevel(String foodieLevel) {
        this.foodieLevel = foodieLevel;
    }

    public int getFoodieLevelNum() {
        return foodieLevelNum;
    }

    public void setFoodieLevelNum(int foodieLevelNum) {
        this.foodieLevelNum = foodieLevelNum;
    }

    public String getFoodieColor() {
        return foodieColor;
    }

    public void setFoodieColor(String foodieColor) {
        this.foodieColor = foodieColor;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileDeeplink() {
        return profileDeeplink;
    }

    public void setProfileDeeplink(String profileDeeplink) {
        this.profileDeeplink = profileDeeplink;
    }
}
