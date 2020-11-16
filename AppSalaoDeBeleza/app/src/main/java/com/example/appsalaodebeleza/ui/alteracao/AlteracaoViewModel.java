package com.example.appsalaodebeleza.ui.alteracao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlteracaoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AlteracaoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is alteracao fragment");
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}