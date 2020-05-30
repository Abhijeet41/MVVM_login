package com.abhi41.mvvm_login.viewModel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.abhi41.mvvm_login.Callbacks.Api;
import com.abhi41.mvvm_login.Model.HeroModel;
import com.abhi41.mvvm_login.Model.StateModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Recycler_View_Model extends AndroidViewModel {

    private MutableLiveData<List<HeroModel>> mNicePlaces;
    private MutableLiveData<List<StateModel>> statMutableList;

    public Recycler_View_Model(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<HeroModel>> getNicePlaces(){
        if (mNicePlaces == null)
        {
            mNicePlaces = new MutableLiveData<List<HeroModel>>();
            loadPlaceModeles();
        }
        return mNicePlaces;
    }

    public LiveData<List<StateModel>> getState()
    {
        if (statMutableList == null)
        {
            statMutableList = new MutableLiveData<>();
            loadStateModels();
        }
        return statMutableList;
    }

    private void loadPlaceModeles() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<HeroModel>> call = api.getHeroes();

        call.enqueue(new Callback<List<HeroModel>>() {
            @Override
            public void onResponse(Call<List<HeroModel>> call, Response<List<HeroModel>> response) {
                mNicePlaces.setValue(response.body());
                Toast.makeText(getApplication(), ""+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<HeroModel>> call, Throwable t) {
                Toast.makeText(getApplication(), "", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void loadStateModels()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<StateModel>> call = api.getState();

        call.enqueue(new Callback<List<StateModel>>() {
            @Override
            public void onResponse(Call<List<StateModel>> call, Response<List<StateModel>> response) {
                statMutableList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<StateModel>> call, Throwable t) {

            }
        });
    }


}
