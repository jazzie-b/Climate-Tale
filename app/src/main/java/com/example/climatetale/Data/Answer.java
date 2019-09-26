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
    @PrimaryKey
    public int answerID;
    public int questionID;
    public int answer;
    public boolean isCorrect;

    //Constructor
    public Answer(int answerID, int questionID, int answer, boolean isCorrect) {
        this.answerID = answerID;
        this.questionID = questionID;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }
}

