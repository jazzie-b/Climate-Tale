package com.example.climatetale.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TopicDao {
    //Actions
    @Insert
    void insert(Topic topic);

    @Update
    void update(Topic topic);

    @Delete
    void delete(Topic topic);

    //Queries
    //Update the topic ID based on topic name
    @Query("UPDATE Topic SET topicID =:topicID WHERE topicName =:topicName")
    void updateTopicID(int topicID, String topicName);

    //Update the topic Number
    @Query("UPDATE Topic SET topicNumber =:topicNumber WHERE topicID =:topicID")
    void updateTopicNumber(int topicID, int topicNumber);

    //Update the topic name
    @Query("UPDATE Topic SET topicName =:topicName WHERE topicID =:topicID")
    void updateTopicName(int topicID, String topicName);

    //Update whether the topic is completed
    @Query("UPDATE Topic SET completedTopic =:isComplete WHERE topicID =:topicID")
    void updateCompletedTopic(int topicID, boolean isComplete);

    //Get topic ID
    @Query("SELECT topicID FROM Topic WHERE topicName =:topicName")
    int getTopicID(String topicName);

    //Get topic number
    @Query("SELECT topicNumber FROM Topic WHERE topicID =:topicID")
    int getTopicNumber(int topicID);

    //Get topic name
    @Query("SELECT topicName FROM Topic WHERE topicID =:topicID")
    String getTopicName(int topicID);

    //Get whether the topic is completed
    @Query("SELECT completedTopic FROM Topic WHERE topicID =:topicID")
    boolean getCompletedTopic(int topicID);
}
