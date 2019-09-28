package com.example.climatetale.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AnswerDao {
    //Actions
    @Insert
    void insert(Answer answer);

    @Update
    void update(Answer answer);

    @Delete
    void delete(Answer answer);

    //Queries
    //Update Answer ID
    @Query("UPDATE Answer SET answerID =:answerID WHERE questionID=:questionID")
    void updateAnswerID(int questionID, int answerID);

    //Update Answer
    @Query("UPDATE Answer SET answer =:answer WHERE answerID =:answerID")
    void updateAnswer(int answerID, String answer);

    //Update Correct
    @Query("UPDATE Answer SET isCorrect =:isCorrect WHERE answerID =:answerID")
    void updateIsCorrect(int answerID, boolean isCorrect);

    //Get Answer ID
    @Query("SELECT answerID FROM Answer WHERE questionID =:questionID")
    int getAnswerID(int questionID);

    //Get Answer
    @Query("SELECT answer FROM Answer WHERE answerID =:answerID")
    String getAnswer(int answerID);

    //Get Correct
    @Query("SELECT isCorrect FROM Answer WHERE answerID =:answerID")
    boolean getIsCorrect(int answerID);
}
