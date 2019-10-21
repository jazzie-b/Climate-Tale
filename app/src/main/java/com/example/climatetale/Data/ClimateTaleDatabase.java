package com.example.climatetale.Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities ={AppInfo.class, UserInfo.class, Chapter.class, Topic.class, Quiz.class, Question.class, Answer.class}, exportSchema = false, version = 1)
public abstract class ClimateTaleDatabase extends RoomDatabase {

    private static ClimateTaleDatabase INSTANCE;

    public abstract AppInfoDao appInfoDao();
    public abstract UserInfoDao userInfoDao();
    public abstract ChapterDao chapterDao();
    public abstract TopicDao topicDao();
    public abstract QuizDao quizDao();
    public abstract QuestionDao questionDao();
    public abstract AnswerDao answerDao();

    public static synchronized ClimateTaleDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ClimateTaleDatabase.class, "climate-tale-database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build();
        }
        return INSTANCE;
    }

}
