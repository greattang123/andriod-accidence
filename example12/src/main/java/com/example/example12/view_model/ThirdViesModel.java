package com.example.example12.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ThirdViesModel extends AndroidViewModel {
    private static final String TAG = "ThirdViewModel";
    public MutableLiveData<Boolean> checked = new MutableLiveData<>();
    public MutableLiveData<String> userName = new MutableLiveData<>();
    public ThirdViesModel(@NonNull Application application) {
        super(application);
        userName.setValue("GT");
    }
    public void change() {
        userName.setValue("GT");
    }
}
