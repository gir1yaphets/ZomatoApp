package com.example.zomatoapp.dataModel.realmObject;

import io.realm.RealmObject;

public class DbPhotosModel extends RealmObject {
    private String id;
    private String url;
    private String thumbUrl;
    private int resId;
    private String caption;
    private int timestamp;
    private String friendlyTime;
    private int width;
    private int height;
}
