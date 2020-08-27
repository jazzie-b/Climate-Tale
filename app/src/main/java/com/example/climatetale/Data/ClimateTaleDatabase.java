package com.example.climatetale.Data;

import android.content.Context;

import androidx.room.*;

@Database(entities ={AppInfo.class, UserInfo.class, Chapter.class, Topic.class, Quiz.class, Question.class, Answer.class}, exportSchema = false, version = 1)
public abstract class ClimateTaleDatabase extends RoomDatabase {

    //Database
    private static ClimateTaleDatabase climateTaleDB;

    //Entities
    public abstract AppInfoDao appInfoDao();
    public abstract UserInfoDao userInfoDao();
    public abstract ChapterDao chapterDao();
    public abstract TopicDao topicDao();
    public abstract QuizDao quizDao();
    public abstract QuestionDao questionDao();
    public abstract AnswerDao answerDao();

    //Used to get instance of Database
    public static ClimateTaleDatabase getInstance(Context context) {
        if (null == climateTaleDB) {
            climateTaleDB = buildDatabaseInstance(context);
        }

        return climateTaleDB;
    }

    //Build database
    private static ClimateTaleDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context, ClimateTaleDatabase.class, "climateTaleDB")
                .createFromAsset("database/climate-tale-database.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

}
