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
    //Update chapter ID
    @Query("UPDATE Chapter SET chapterID =:chapterID WHERE chapterNumber =:chapterNumber")
    void updateChapterID(int chapterID, int chapterNumber);

    //Update chapter number
    @Query("UPDATE Chapter SET chapterNumber =:chapterNumber WHERE chapterID =:chapterID")
    void updateChapterNumber(int chapterID, int chapterNumber);

    //Update chapter name
    @Query("UPDATE Chapter SET chapterName =:chapterName WHERE chapterID =:chapterID")
    void updateChapterName(int chapterID, String chapterName);

    //Update completed chapter
    @Query("UPDATE Chapter SET completedChapter =:isComplete WHERE chapterID =:chapterID")
    void updateCompleteChapter(boolean isComplete, int chapterID);

    //get chapter id
    @Query("SELECT chapterID FROM Chapter WHERE chapterName=:chapterName")
    int getChapterID(String chapterName);

    //get chapter name
    @Query("SELECT chapterName FROM Chapter WHERE chapterID=:chapterID")
    String getChapterName(int chapterID);

    //get chapter number
    @Query("SELECT chapterNumber FROM Chapter WHERE chapterID=:chapterID")
    int getChapterNumber(int chapterID);

    //get chapter completed
    @Query("SELECT completedChapter FROM Chapter WHERE chapterID=:chapterID")
    boolean getCompleteChapter(int chapterID);
}
