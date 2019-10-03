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
            new PopulateDbAsyncTask(instance);
        }
    };

    //async task
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserInfoDao userInfoDao;
        private AppInfoDao appInfoDao;

        private PopulateDbAsyncTask(ClimateTaleDatabase db){
            userInfoDao = db.getUserInfoDao();
            appInfoDao = db.getAppInfoDao();
        }

        @Override
        protected Void doInBackground(Void... voids){
            //Start up data for database
            appInfoDao.insert(new AppInfo(1, 1,1));
            userInfoDao.insert(new UserInfo(1, "Hello", 0,0,0,01));

            return null;
        }
    }

}
