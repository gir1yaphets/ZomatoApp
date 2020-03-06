package com.example.zomatoapp.dataModel.realmObject;

import io.realm.RealmObject;

public class DbLocationModel extends RealmObject {
    private String address;
    private String locality;
    private String city;
    private int cityId;
    private String latitude;
    private String longitude;
    private String zipcode;
    private int countryId;
    private String localityVerbose;
}
