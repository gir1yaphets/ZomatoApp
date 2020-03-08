package com.example.zomatoapp.eventbus;

import com.example.zomatoapp.dataModel.CityModel;

public class OnCitySuccessEvent {
    private CityModel cityModel;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    private int category;

    public OnCitySuccessEvent(int category, CityModel cityModel) {
        this.category = category;
        this.cityModel = cityModel;
    }

    public CityModel getCityModel() {
        return cityModel;
    }
}
