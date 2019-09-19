package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Question.class,
        parentColumns = "questionID",
        childColumns = "questionID",
        onDelete = CASCADE))
public class Answer {
    public int questionID;
    @PrimaryKey
    public int answer;
    public boolean correct;

    //Constructor
    public Answer(int questionID, int answer, boolean correct) {
        this.questionID = questionID;
        this.answer = answer;
        this.correct = correct;
    }
}

