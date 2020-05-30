package com.abhi41.mvvm_login.viewModel;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.abhi41.mvvm_login.Callbacks.Logincallback;
import com.abhi41.mvvm_login.Model.LoginModel;

public class LoginViewModel extends ViewModel {

    private LoginModel loginModel;
    private Logincallback logincallback;

    public LoginViewModel(Logincallback logincallback) {
        this.logincallback = logincallback;
        this.loginModel = new LoginModel();
    }

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    public Logincallback getLogincallback() {
        return logincallback;
    }

    public void setLogincallback(Logincallback logincallback) {
        this.logincallback = logincallback;
    }

    public TextWatcher emailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                loginModel.setEmail(s.toString());
            }
        };
    }

    public TextWatcher passwordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                loginModel.setPassword(s.toString());
            }
        };
    }

    public void onLoginBtnClick(View view) {
        if (loginModel.idValid()) {
            String email = loginModel.getEmail();
            Log.d("email", email);
            logincallback.onSuccess("Successful");
        } else {
            logincallback.onFailure("failed");
        }
    }
}
