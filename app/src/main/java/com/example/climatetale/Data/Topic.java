package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Chapter.class,
        parentColumns = "chapterID",
        childColumns = "chapterID",
        onDelete = CASCADE),
        indices = {@Index(value = "chapterID")})
public class Topic {
    @PrimaryKey
    public int topicID;
    public int topicNumber;
    public String topicName;
    public int chapterID;
    public boolean completedTopic;

    //Constructor
    public Topic(int topicID, int topicNumber, String topicName, int chapterID, boolean completedTopic) {
        this.topicID = topicID;
        this.topicNumber = topicNumber;
        this.topicName = topicName;
        this.chapterID = chapterID;
        this.completedTopic = completedTopic;
    }
}
