package com.abhi41.mvvm_login.Model;

import com.google.gson.annotations.SerializedName;

public class DistrictModel {
    @SerializedName("name")
    String name;

    @SerializedName("confirmed")
    String confirmed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }
}
