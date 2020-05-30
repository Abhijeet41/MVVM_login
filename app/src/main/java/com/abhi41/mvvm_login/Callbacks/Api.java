package com.abhi41.mvvm_login.Callbacks;

import com.abhi41.mvvm_login.Model.HeroModel;
import com.abhi41.mvvm_login.Model.StateModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<HeroModel>> getHeroes();

    String url = "https://api.covidindiatracker.com/";

    @GET("state_data.json#")
    Call<List<StateModel>> getState();
}
