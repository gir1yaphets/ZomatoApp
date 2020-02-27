package com.example.zomatoapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class RestRatingViewModel extends AndroidViewModel {
    public MutableLiveData<String> score = new MutableLiveData<>();
    public MutableLiveData<String> raters = new MutableLiveData<>();

    public RestRatingViewModel(@NonNull Application application) {
        super(application);
    }
}
