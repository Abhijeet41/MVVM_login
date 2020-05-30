package com.abhi41.mvvm_login.ViewModelFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.abhi41.mvvm_login.Callbacks.Logincallback;
import com.abhi41.mvvm_login.viewModel.LoginViewModel;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Logincallback logincallback;

    public LoginViewModelFactory(Logincallback logincallback) {
        this.logincallback = logincallback;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(logincallback);
    }
}
