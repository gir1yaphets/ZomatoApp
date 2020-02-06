package com.example.zomatoapp.viewModel;

import androidx.databinding.ObservableField;

public class RestaurantItemViewModel {
    public ObservableField<String> name = new ObservableField<>();

    public ObservableField<String> rating = new ObservableField<>();

    public ObservableField<String> description = new ObservableField<>();

    public ObservableField<String> status = new ObservableField<>();

    public ObservableField<String> location = new ObservableField<>();

    public ObservableField<String> price = new ObservableField<>();
}
