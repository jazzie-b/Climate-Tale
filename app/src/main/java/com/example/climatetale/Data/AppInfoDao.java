package com.example.climatetale.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AppInfoDao {
    //Actions
    @Insert
    void insert(AppInfo appInfo);

    @Update
    void update(AppInfo appInfo);

    @Delete
    void delete(AppInfo appInfo);

    //Queries
    //Update total chapters within app as a value
    @Query("UPDATE AppInfo SET totalChapters =:total WHERE appID =:appID")
    void updateTotalChapters(int total, int appID);

    //Update total topics within app as a value
    @Query("UPDATE AppInfo SET totalTopics =:total WHERE appID =:appID")
    void updateTotalTopics(int total, int appID);

    //Get appId where the total chapters amounts match
    @Query("SELECT appID FROM AppInfo WHERE totalChapters =:totalChapters")
    int getAppId(int totalChapters);

    //Get total chapters for set appID
    @Query("SELECT totalChapters FROM AppInfo WHERE appID =:appID")
    int getTotalChapters(int appID);

    //Get total topics for set appID
    @Query("SELECT totalTopics FROM AppInfo WHERE appID =:appID")
    int getTotalTopics(int appID);

    //get app info object
    @Query("SELECT * FROM AppInfo WHERE appID =:appID")
    AppInfo getAppInfo(int appID);
}
