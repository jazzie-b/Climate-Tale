package com.example.climatetale.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface QuizDao {
    //Actions
    @Insert
    void insert(Quiz quiz);

    @Update
    void update(Quiz quiz);

    @Delete
    void delete(Quiz quiz);

    //Queries
    //Update quiz id
    @Query("UPDATE Quiz SET quizID =:quizID WHERE quizName =:quizName")
    void updateQuizID(int quizID, String quizName);

    //Update quiz name
    @Query("UPDATE Quiz SET quizName =:quizName WHERE quizID =:quizID")
    void updateQuizName(int quizID, String quizName);

    //Update if the quiz was passed or not
    @Query("UPDATE Quiz SET hasPassed =:hasPassed WHERE quizID =:quizID")
    void updateHasPassed(int quizID, boolean hasPassed);

    //get quiz id
    @Query("SELECT quizID FROM Quiz WHERE quizName =:quizName")
    int getQuizID(String quizName);

    //get quiz name
    @Query("SELECT quizName FROM Quiz WHERE quizID =:quizID")
    String getQuizName(int quizID);

    //get if the quiz is passed
    @Query("SELECT hasPassed FROM Quiz WHERE quizID =:quizID")
    boolean getHasPassed(int quizID);

    //get quiz object
    @Query("SELECT * FROM Quiz WHERE quizID =:quizID")
    Quiz getQuiz(int quizID);

    //get topic ID from quiz id
    @Query("SELECT topicID FROM Quiz WHERE quizID=:quizID")
    int getTopicID(int quizID);

}
