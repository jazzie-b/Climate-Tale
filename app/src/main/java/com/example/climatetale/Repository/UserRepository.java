package com.example.climatetale.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.climatetale.Data.ClimateTaleDatabase;
import com.example.climatetale.Data.UserInfo;
import com.example.climatetale.Data.UserInfoDao;

public class UserRepository {
    private UserInfoDao userInfoDao;
    private LiveData<UserInfo> userInfo;

    public UserRepository(Application application){
        //Connect to database
        ClimateTaleDatabase db = ClimateTaleDatabase.getInstance(application);
        //get dao
        userInfoDao = db.getUserInfoDao();
        userInfo = userInfoDao.getUserInfo(01);
    }

    //Database operations
    public void insert(UserInfo userInfo){
        new InsertUserInfoAsyncTask(userInfoDao).execute(userInfo);
    }

    public void update(UserInfo userInfo){
        new UpdateUserInfoAsyncTask(userInfoDao).execute(userInfo);
    }

    //Live data objects methods
    public LiveData<UserInfo> getUserInfo() {
        return userInfo;
    }



    //Access Database operations
    private static class InsertUserInfoAsyncTask extends AsyncTask<UserInfo, Void, Void>{
        private UserInfoDao userInfoDao;

        private InsertUserInfoAsyncTask(UserInfoDao userInfoDao){
            this.userInfoDao = userInfoDao;
        }

        @Override
        protected Void doInBackground(UserInfo... userInfos){
            userInfoDao.insert(userInfos[0]);
            return null;
        }
    }

    private static class UpdateUserInfoAsyncTask extends AsyncTask<UserInfo, Void, Void>{
        private UserInfoDao userInfoDao;

        private UpdateUserInfoAsyncTask(UserInfoDao userInfoDao){
            this.userInfoDao = userInfoDao;
        }

        @Override
        protected Void doInBackground(UserInfo... userInfos){
            userInfoDao.update(userInfos[0]);
            return null;
        }
    }

   }
