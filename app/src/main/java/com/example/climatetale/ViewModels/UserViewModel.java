package com.example.climatetale.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


import com.example.climatetale.Data.UserInfo;
import com.example.climatetale.Repository.UserRepository;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;
    private UserInfo userInfo;

    public UserViewModel(@NonNull Application application) {
        super(application);
        //repository connection
        repository = new UserRepository(application);
        userInfo = repository.getUserInfo();
    }

    //Repository methods
    public void insert(UserInfo userInfo) {
        repository.insert(userInfo);
    }

    public void update(UserInfo userInfo) {
        repository.update(userInfo);
    }

    //get user name
    public String getUserName(){
        return repository.getUserInfo().name;
    }

    //set user name
    public void updateUserName(String name){
        repository.updateUserName(name);
    }

}
