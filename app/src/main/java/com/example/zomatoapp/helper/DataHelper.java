package com.example.zomatoapp.helper;

import com.example.zomatoapp.dataModel.requestModel.RequestDataModel;

public interface DataHelper {
    void retrieveData(RequestDataModel requestDataModel);

    void deleteAllData(RequestDataModel requestDataModel);
}
