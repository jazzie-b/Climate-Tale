package com.example.climatetale.Repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.climatetale.Data.ClimateTaleDatabase;
import com.example.climatetale.Data.UserInfo;
import com.example.climatetale.Data.UserInfoDao;

public class UserRepository {
    private UserInfoDao userInfoDao;
    private UserInfo userInfo;
    private String userName;

    public UserRepository(Application application){
        //Connect to database
        ClimateTaleDatabase db = ClimateTaleDatabase.getInstance(application);
        //get dao
        userInfoDao = db.getUserInfoDao();
    }

    //Database operations
    public void insert(UserInfo userInfo){
        new InsertUserInfoAsyncTask(userInfoDao).execute(userInfo);
    }

    public void update(UserInfo userInfo){
        new UpdateUserInfoAsyncTask(userInfoDao).execute(userInfo);
    }

    //objects methods
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void updateUserName(String name){
        userName = name;
        userInfoDao.updateName(name,1);
    }

    public String getUserName(){
        return userInfoDao.getUserInfo(1).name;
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

    public static class UpdateUserNameAsyncTask extends AsyncTask<String, Void, Void>{
        private  UserInfoDao userInfoDao;

        private UpdateUserNameAsyncTask(UserInfoDao userInfoDao){
            this.userInfoDao = userInfoDao;
        }

        @Override
        protected Void doInBackground(String... strings){
            userInfoDao.updateName(strings[0], 01);
            return null;
        }

    }


   }
