package com.example.climatetale.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Answer.class, AppInfo.class, Chapter.class, Question.class, Quiz.class, Topic.class, UserInfo.class},
        version = 1)
public abstract class ClimateTaleDatabase extends RoomDatabase {
    public abstract AnswerDao getAnswerDao();
    public abstract AppInfoDao getAppInfoDao();
    public abstract ChapterDao getChapterDao();
    public abstract QuestionDao getQuestionDao();
    public abstract QuizDao getQuizDao();
    public abstract TopicDao getTopicDao();
    public abstract UserInfoDao getUserInfoDao();
}
