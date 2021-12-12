package com.example.bodycalculator.ui.select_index;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SelectIndexViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SelectIndexViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}