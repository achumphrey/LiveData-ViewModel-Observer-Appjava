package com.example.livedataviewmodelobserverappjava;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

class NameViewModel extends ViewModel {

    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName(){

        if (currentName == null){
            currentName = new MutableLiveData<>();
        }
        return currentName;
    }

    // Dispose All your Subscriptions to avoid memory leaks
    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public NameViewModel() {
        super();
    }
}
