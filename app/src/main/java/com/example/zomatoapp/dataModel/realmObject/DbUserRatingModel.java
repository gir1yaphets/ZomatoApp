package com.example.zomatoapp.dataModel.realmObject;

import io.realm.RealmObject;

public class DbUserRatingModel extends RealmObject {
    private String aggregateRating;
    private String ratingText;
    private String ratingColor;
    private String votes;
}
