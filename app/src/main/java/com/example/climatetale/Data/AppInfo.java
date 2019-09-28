package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity
public class AppInfo {
    @PrimaryKey
    public int appID;
    public int totalTopics;
    public int totalChapters;

    //Constructor
    public AppInfo(int appID, int totalTopics, int totalChapters) {
        this.appID = appID;
        this.totalTopics = totalTopics;
        this.totalChapters = totalChapters;
    }
}
