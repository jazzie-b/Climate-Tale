package com.example.climatetale.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ChapterDao {
    //Actions
    @Insert
    void insert(Chapter chapter);

    @Update
    void update(Chapter chapter);

    @Delete
    void delete(Chapter chapter);

    //Queries
    //Update chapter ID based on chapter number
    @Query("UPDATE Chapter SET chapterID =:chapterID WHERE chapterNumber =:chapterNumber")
    void updateChapterID(int chapterID, int chapterNumber);

    //Update chapter number based on chapter ID
    @Query("UPDATE Chapter SET chapterNumber =:chapterNumber WHERE chapterID =:chapterID")
    void updateChapterNumber(int chapterID, int chapterNumber);

    //Update chapter name based on Chapter ID
    @Query("UPDATE Chapter SET chapterName =:chapterName WHERE chapterID =:chapterName")
    void updateChapterName(int chapterID, String chapterName);

    //Update completed chapter boolean
    @Query("UPDATE Chapter SET completedChapter =:isComplete WHERE chapterID =:chapterID")
    void updateCompleteChapter(boolean isComplete, int chapterID);

    //get chapter id
    @Query("SELECT chapterID FROM Chapter WHERE chapterName=:chapterName")
    int getChapterID(String chapterName);

    //get chapter name
    @Query("SELECT chapterName FROM Chapter WHERE chapterID=:chapterID")
    String getChapterName(int chapterID);

    //get chapter completed
    @Query("SELECT completedChapter FROM Chapter WHERE chapterID=:chapterID")
    boolean getCompleteChapter(int chapterID);
}
