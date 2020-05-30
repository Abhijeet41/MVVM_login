package com.abhi41.mvvm_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.abhi41.mvvm_login.Callbacks.Logincallback;
import com.abhi41.mvvm_login.viewModel.LoginViewModel;
import com.abhi41.mvvm_login.ViewModelFactory.LoginViewModelFactory;
import com.abhi41.mvvm_login.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Logincallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this,new LoginViewModelFactory(this)).get(LoginViewModel.class));

    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }
}
