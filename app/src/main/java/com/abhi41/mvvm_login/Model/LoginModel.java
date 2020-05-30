package com.abhi41.mvvm_login.Model;

import android.text.TextUtils;

import androidx.annotation.Nullable;

public class LoginModel {
    @Nullable
    String email, password;

    public LoginModel() {
    }

    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean idValid(){
        return !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) &&
                getPassword().length()>6;
    }
}
