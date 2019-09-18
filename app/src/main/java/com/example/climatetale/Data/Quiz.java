package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Topic.class,
        parentColumns = "topicID",
        childColumns = "topicID",
        onDelete = CASCADE))
public class Quiz {
    @PrimaryKey
    public int quizID;
    public int topicID;

    public Quiz(int quizID, int topicID) {
        this.quizID = quizID;
        this.topicID = topicID;
    }
}
