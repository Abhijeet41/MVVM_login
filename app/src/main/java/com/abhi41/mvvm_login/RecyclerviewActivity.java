package com.abhi41.mvvm_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.abhi41.mvvm_login.Adapter.HeroAdapter;
import com.abhi41.mvvm_login.Model.HeroModel;
import com.abhi41.mvvm_login.Model.StateModel;
import com.abhi41.mvvm_login.viewModel.Recycler_View_Model;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewActivity extends AppCompatActivity {

    private RecyclerView recylerview;
    private HeroAdapter mAdapter;
    Recycler_View_Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        recylerview = findViewById(R.id.recylerview);

        initRecyclerview();
    }

    private void initRecyclerview() {

        model = ViewModelProviders.of(this).get(Recycler_View_Model.class);
        model.getNicePlaces().observe(this, new Observer<List<HeroModel>>() {
            @Override
            public void onChanged(List<HeroModel> heroModels) {
                mAdapter = new HeroAdapter(RecyclerviewActivity.this, heroModels);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerviewActivity.this);
                recylerview.setLayoutManager(layoutManager);
                recylerview.setAdapter(mAdapter);
            }
        });

        model.getState().observe(this, new Observer<List<StateModel>>() {
            @Override
            public void onChanged(List<StateModel> stateModels) {
                stateModels.toString();

                for (StateModel s :stateModels)
                {
                    s.getState();
                    s.getState();
                    s.getDistrictModelArrayList();
                }
            }
        });


    }
}
