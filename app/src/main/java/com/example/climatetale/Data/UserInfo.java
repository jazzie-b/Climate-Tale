package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = AppInfo.class,
        parentColumns = "appID",
        childColumns = "appID",
        onDelete = CASCADE))
public class UserInfo {
    @PrimaryKey
    public int userID;
    public String name;
    public int progressOverall;
    public int progressChapter;
    public int progressTopic;
    public int appID;

    //Constructor
    public UserInfo(int userID, String name, int progressOverall, int progressChapter, int progressTopic, int appID) {
        this.userID = userID;
        this.name = name;
        this.progressOverall = progressOverall;
        this.progressChapter = progressChapter;
        this.progressTopic = progressTopic;
        this.appID = appID;
    }
}
