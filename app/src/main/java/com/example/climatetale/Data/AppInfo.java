package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = UserInfo.class,
        parentColumns = "userID",
        childColumns = "userID",
        onDelete = CASCADE))
public class AppInfo {
    @PrimaryKey
    public int totalTopics;
    public int totalChapters;
    public int userID;

    //Constructor
    public AppInfo(int totalTopics, int totalChapters, int userID) {
        this.totalTopics = totalTopics;
        this.totalChapters = totalChapters;
        this.userID = userID;
    }
}
