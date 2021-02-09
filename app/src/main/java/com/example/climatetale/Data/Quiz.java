package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Topic.class,
        parentColumns = "topicID",
        childColumns = "topicID",
        onDelete = CASCADE),
        indices = {@Index(value = "topicID")})
public class Quiz {
    @PrimaryKey
    public int quizID;
    public String quizName;
    public int topicID;
    public boolean hasPassed;

    //Constructor
    public Quiz(int quizID, String quizName, int topicID, boolean hasPassed) {
        this.quizID = quizID;
        this.quizName = quizName;
        this.topicID = topicID;
        this.hasPassed = hasPassed;
    }
}
