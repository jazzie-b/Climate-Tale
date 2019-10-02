package com.example.climatetale.Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Answer.class, AppInfo.class, Chapter.class, Question.class, Quiz.class, Topic.class, UserInfo.class},
        version = 1)
public abstract class ClimateTaleDatabase extends RoomDatabase {

    private static ClimateTaleDatabase instance;

    public abstract AnswerDao getAnswerDao();
    public abstract AppInfoDao getAppInfoDao();
    public abstract ChapterDao getChapterDao();
    public abstract QuestionDao getQuestionDao();
    public abstract QuizDao getQuizDao();
    public abstract TopicDao getTopicDao();
    public abstract UserInfoDao getUserInfoDao();

    public  static synchronized ClimateTaleDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ClimateTaleDatabase.class, "climate_tale_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
