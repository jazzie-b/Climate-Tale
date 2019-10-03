package com.example.climatetale.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.climatetale.Data.UserInfo;
import com.example.climatetale.Repository.UserRepository;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;
    private LiveData<UserInfo> userInfo;

    public UserViewModel(@NonNull Application application) {
        super(application);
        //repository connection
        repository = new UserRepository(application);
        userInfo = repository.getUserInfo();
    }

    //Repository methods
    public void insert(UserInfo userInfo){
        repository.insert(userInfo);
    }

    public void update(UserInfo userInfo){
        repository.update(userInfo);
    }

    /*public MutableLiveData<String> getUserName(){
        return repository.getUserName(01);
    }

    public void setUserName(String name){
        repository.setUserName(name);
    }*/

    public LiveData<UserInfo> getUserInfo(){
        return repository.getUserInfo();
    }

    /*public void init(Context c){
        if(usersName.equals(null)){
            addNameDialog(c);
        }

    }

    public String getUsersName() {
        return usersName;
    }

    public void addNameDialog(Context c) {
        final EditText editText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Welcome")
                .setMessage("What is your name?")
                .setView(editText)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        usersName = String.valueOf(editText.getText());
                    }
                })
                .create();
        dialog.show();
    }*/
}
