package com.abhi41.mvvm_login.Model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StateModel {
   // @Nullable
    @SerializedName("state")
    String state;
  //  @Nullable
    @SerializedName("active")
    String active;
    //@Nullable
    @SerializedName("confirmed")
    String confirmed;
 //   @Nullable
    @SerializedName("districtData")
    ArrayList<DistrictModel> districtModelArrayList;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public ArrayList<DistrictModel> getDistrictModelArrayList() {
        return districtModelArrayList;
    }

    public void setDistrictModelArrayList(ArrayList<DistrictModel> districtModelArrayList) {
        this.districtModelArrayList = districtModelArrayList;
    }
}
