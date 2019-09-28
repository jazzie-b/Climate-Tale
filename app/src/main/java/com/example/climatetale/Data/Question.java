package com.example.climatetale.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Quiz.class,
        parentColumns = "quizID",
        childColumns = "quizID",
        onDelete = CASCADE))
public class Question {
    @PrimaryKey
    public int questionID;
    public int quizID;
    public String question;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public int selection;

    //Constructor
    public Question(int questionID, int quizID, String question, String option1, String option2, String option3, String option4, int selection) {
        this.questionID = questionID;
        this.quizID = quizID;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.selection = selection;
    }
}
