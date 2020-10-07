package com.example.livedataviewmodelobserverappjava;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class NameViewModelFactory implements ViewModelProvider.Factory{

    public NameViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NameViewModel.class)) {
            return (T) new NameViewModel();
        }
        //noinspection "unchecked"
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
