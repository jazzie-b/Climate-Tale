package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = AppInfo.class,
        parentColumns = "totalTopics",
        childColumns = "totalTopics",
        onDelete = CASCADE))
public class Chapter {
    @PrimaryKey
    public int chapterID;
    public int chapterNumber;
    public String chapterName;
    public int totalTopics;

    public Chapter(int chapterID, int chapterNumber, String chapterName, int totalTopics) {
        this.chapterID = chapterID;
        this.chapterNumber = chapterNumber;
        this.chapterName = chapterName;
        this.totalTopics = totalTopics;
    }
}
