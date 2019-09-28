package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = AppInfo.class,
        parentColumns = "appID",
        childColumns = "appID",
        onDelete = CASCADE))
public class Chapter {
    @PrimaryKey
    public int chapterID;
    public int chapterNumber;
    public String chapterName;
    public int appID;
    public boolean completedChapter;

    //Constructor

    public Chapter(int chapterID, int chapterNumber, String chapterName, int appID, boolean completedChapter) {
        this.chapterID = chapterID;
        this.chapterNumber = chapterNumber;
        this.chapterName = chapterName;
        this.appID = appID;
        this.completedChapter = completedChapter;
    }
}
