package com.example.climatetale.Repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.climatetale.Data.AppInfo;
import com.example.climatetale.Data.AppInfoDao;
import com.example.climatetale.Data.ClimateTaleDatabase;

public class AppInfoRepository {

    private AppInfoDao appInfoDao;
    private AppInfo appInfo;

    public AppInfoRepository(Application application){
        //Connect to database
        ClimateTaleDatabase db = ClimateTaleDatabase.getInstance(application);
        //get dao
        appInfoDao = db.getAppInfoDao();
        appInfo = appInfoDao.getAppInfo(1);
    }

    //Database Operations
    public void insert(AppInfo appInfo){
        new InsertAppInfoAsyncTask(appInfoDao).execute(appInfo);
    }

    public void update (AppInfo appInfo){
        new UpdateUserInfoAsyncTask(appInfoDao).execute(appInfo);
    }

    //Data
    public AppInfo getAppInfo(){
        return appInfo;
    }

    //Access database operations
    private static class InsertAppInfoAsyncTask extends AsyncTask<AppInfo, Void, Void>{
        private AppInfoDao appInfoDao;

        private InsertAppInfoAsyncTask(AppInfoDao appInfoDao){
            this.appInfoDao = appInfoDao;
        }

        @Override
        protected Void doInBackground(AppInfo... appInfos){
            appInfoDao.insert(appInfos[0]);
            return null;
        }
    }

    private static class UpdateUserInfoAsyncTask extends AsyncTask<AppInfo, Void, Void>{
        private AppInfoDao appInfoDao;

        private UpdateUserInfoAsyncTask(AppInfoDao appInfoDao){
            this.appInfoDao = appInfoDao;
        }

        @Override
        protected Void doInBackground(AppInfo... appInfos){
            appInfoDao.update(appInfos[0]);
            return null;
        }
    }
}
