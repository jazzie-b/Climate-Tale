package com.example.climatetale.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserInfoDao {
    //Actions
    @Insert
    void insert(UserInfo userInfo);

    @Update
    void update(UserInfo userInfo);

    @Delete
    void delete(UserInfo userInfo);

    //Queries
    //Update user's name
    @Query("UPDATE UserInfo SET name =:name WHERE userID = :userID ")
    void updateName(String name, int userID);

    //Update user's overall progress
    @Query("UPDATE UserInfo SET progressOverall =:progress WHERE userID =:userID")
    void updateOverallProgress(int progress, int userID);

    //Update user's chapters progress
    @Query("UPDATE UserInfo SET progressChapter =:progress WHERE userID =:userID")
    void updateOverallChapter(int progress, int userID);

    //Update user's topic progress
    @Query("UPDATE UserInfo SET progressTopic =:progress WHERE userID =:userID")
    void updateOverallTopic(int progress, int userID);

    //Get user's ID from user's name
    @Query("SELECT userID FROM userinfo WHERE name = :name")
    int getUserID(String name);

    //Get user's name from user's ID
    @Query("SELECT name FROM userinfo WHERE userID =:userID")
    String getName(int userID);

    //Get user's progress overall
    @Query("SELECT progressOverall FROM userinfo WHERE userID =:userID")
    int getProgressOverall(int userID);

    //Get user's chapter progress
    @Query("SELECT progressChapter FROM userinfo WHERE userID =:userID")
    int getProgressChapter(int userID);

    //Get user's topic progress
    @Query("SELECT progressTopic FROM userinfo WHERE userID =:userID")
    int getProgressTopic(int userID);
}
