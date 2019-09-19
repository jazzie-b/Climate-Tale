package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Chapter.class,
        parentColumns = "chapterID",
        childColumns = "chapterID",
        onDelete = CASCADE))
public class Topic {
    @PrimaryKey
    public int topicID;
    public int topicNumber;
    public String TopicName;
    public int chapterID;
    public boolean completedTopic;

    //Constructor
    public Topic(int topicID, int topicNumber, String topicName, int chapterID, boolean completedTopic) {
        this.topicID = topicID;
        this.topicNumber = topicNumber;
        TopicName = topicName;
        this.chapterID = chapterID;
        this.completedTopic = completedTopic;
    }
}
