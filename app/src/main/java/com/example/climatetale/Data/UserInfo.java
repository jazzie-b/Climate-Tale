package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserInfo {
    @PrimaryKey
    public int userID;
    public String name;
    public int progressOverall;
    public int progressChapter;
    public int progressTopic;

    public UserInfo(int userID, String name, int progressOverall, int progressChapter, int progressTopic) {
        this.userID = userID;
        this.name = name;
        this.progressOverall = progressOverall;
        this.progressChapter = progressChapter;
        this.progressTopic = progressTopic;
    }
}
