package com.example.appsalaodebeleza.ui.socios;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SociosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SociosViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is home fragment");
      mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}