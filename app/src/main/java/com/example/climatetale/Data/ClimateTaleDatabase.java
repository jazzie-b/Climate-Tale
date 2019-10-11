package com.example.climatetale.Data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Answer.class, AppInfo.class, Chapter.class, Question.class, Quiz.class, Topic.class, UserInfo.class},
        version = 1, exportSchema = false)
public abstract class ClimateTaleDatabase extends RoomDatabase {

    private static ClimateTaleDatabase instance;

    public abstract AnswerDao getAnswerDao();
    public abstract AppInfoDao getAppInfoDao();
    public abstract ChapterDao getChapterDao();
    public abstract QuestionDao getQuestionDao();
    public abstract QuizDao getQuizDao();
    public abstract TopicDao getTopicDao();
    public abstract UserInfoDao getUserInfoDao();

    public static synchronized ClimateTaleDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ClimateTaleDatabase.class, "climate_tale_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    //populates database
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //Add data to database at load
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    //async task
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserInfoDao userInfoDao;
        private AppInfoDao appInfoDao;
        private ChapterDao chapterDao;
        private TopicDao topicDao;
        private QuizDao quizDao;
        private QuestionDao questionDao;
        private AnswerDao answerDao;

        private PopulateDbAsyncTask(ClimateTaleDatabase db){
            userInfoDao = db.getUserInfoDao();
            appInfoDao = db.getAppInfoDao();
            chapterDao = db.getChapterDao();
            topicDao = db.getTopicDao();
            quizDao = db.getQuizDao();
            questionDao = db.getQuestionDao();
            answerDao = db.getAnswerDao();
        }

        @Override
        protected Void doInBackground(Void... voids){
            //Start up data for database
            appInfoDao.insert(new AppInfo(1, 1,1));
            userInfoDao.insert(new UserInfo(1,
                    "Hello", 0,0,
                    0,1));
            chapterDao.insert(new Chapter(1, 1,
                    "What is Climate Change?", 1,
                    false));
            topicDao.insert(new Topic(101, 1,
                    "CO2 in Atmosphere",1,false));
            quizDao.insert(new Quiz(10101,"Topic 1: CO2 in Atmosphere",
                    101,false));
            questionDao.insert(new Question(101011,10101,
                    "Sample Quiz 1 Question 1",
                    "Sample Option 1 Question 1",
                    "Sample Option 2 Question 1",
                    "Sample Option 3 Question 1",
                    "Sample Option 4 Question 1",
                    0));
            questionDao.insert(new Question(101012,10101,
                    "Sample Quiz 1 Question 2",
                    "Sample Option 1 Question 2",
                    "Sample Option 2 Question 2",
                    "Sample Option 3 Question 2",
                    "Sample Option 4 Question 2",
                    0));
            questionDao.insert(new Question(101013,10101,
                    "Sample Quiz 1 Question 3",
                    "Sample Option 1 Question 3",
                    "Sample Option 2 Question 3",
                    "Sample Option 3 Question 3",
                    "Sample Option 4 Question 3",
                    0));
            answerDao.insert(new Answer(1010111,
                    101011,2,false));
            answerDao.insert(new Answer(1010121,
                    101012,1,false));
            answerDao.insert(new Answer(1010131,
                    101013,1,false));


            return null;
        }
    }

}
