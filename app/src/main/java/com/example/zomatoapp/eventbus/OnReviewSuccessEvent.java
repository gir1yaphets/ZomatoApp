package com.example.zomatoapp.eventbus;

import com.example.zomatoapp.dataModel.AllReviewsModel;

public class OnReviewSuccessEvent {
    private AllReviewsModel allReviewsModel;

    public OnReviewSuccessEvent(AllReviewsModel allReviewsModel) {
        this.allReviewsModel = allReviewsModel;
    }

    public AllReviewsModel getAllReviewsModel() {
        return allReviewsModel;
    }
}
