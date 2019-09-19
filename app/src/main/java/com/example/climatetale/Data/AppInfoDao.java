package com.example.climatetale.Data;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
    @Query("UPDATE AppInfo SET totalChapters =:total")
    void updateTotalChapters(int total);



}
