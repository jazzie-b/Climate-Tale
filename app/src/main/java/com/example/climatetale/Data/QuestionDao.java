package com.example.climatetale.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface QuestionDao {
    //Actions
    @Insert
    void insert(Question question);

    @Update
    void update(Question question);

    @Delete
    void delete(Question question);

    //Queries
    //Update Question ID
    @Query("UPDATE Question SET questionID =:questionID WHERE question =:question")
    void updateQuestionID(int questionID, String question);

    //Update Question
    @Query("UPDATE Question SET question =:question WHERE questionID =:questionID")
    void updateQuestion(int questionID, String question);

    //Update Options 1-4
    @Query("UPDATE Question SET option1 =:option WHERE questionID =:questionID")
    void updateOption1(int questionID, String option);

    @Query("UPDATE Question SET option2 =:option WHERE questionID =:questionID")
    void updateOption2(int questionID, String option);

    @Query("UPDATE Question SET option3 =:option WHERE questionID =:questionID")
    void updateOption3(int questionID, String option);

    @Query("UPDATE Question SET option4 =:option WHERE questionID =:questionID")
    void updateOption4(int questionID, String option);

    //Update Selection
    @Query("UPDATE Question SET selection =:option WHERE questionID =:questionID")
    void updateSelection(int questionID, int option);

    //Get question ID
    @Query("SELECT questionID FROM Question WHERE question =:question")
    int getQuestionID(String question);

    //Get question
    @Query("SELECT question FROM Question WHERE  questionID =:questionID")
    String getQuestion(int questionID);

    //Get options
    @Query("SELECT option1 FROM Question WHERE questionID =:questionID")
    String getOption1(int questionID);

    @Query("SELECT option2 FROM Question WHERE questionID =:questionID")
    String getOption2(int questionID);

    @Query("SELECT option3 FROM Question WHERE questionID =:questionID")
    String getOption3(int questionID);

    @Query("SELECT option4 FROM Question WHERE questionID =:questionID")
    String getOption4(int questionID);

    //Get selection
    @Query("SELECT selection FROM Question WHERE questionID =:questionID")
    int getSelection(int questionID);

    //Get question obj
    @Query("SELECT * FROM Question WHERE questionID =:questionID")
    Question getQuestionObj(int questionID);
}
