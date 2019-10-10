package com.example.climatetale.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.climatetale.Data.ClimateTaleDatabase;
import com.example.climatetale.Data.Quiz;
import com.example.climatetale.Data.QuizDao;

public class QuizRepository {

    public QuizDao quizDao;
    public Quiz quiz;

    public QuizRepository(Application application, int quizID){
        //Connect to database
        ClimateTaleDatabase db = ClimateTaleDatabase.getInstance(application);
        //get dao
        quizDao = db.getQuizDao();
        quiz = quizDao.getQuiz(quizID);
    }

    //Database operations
    public void insert(Quiz quiz){
        new InsertQuizAsyncTask(quizDao).execute(quiz);
    }

    public void update(Quiz quiz){
        new UpdateQuizAsyncTask(quizDao).execute(quiz);
    }

    //Objects methods
    //get a specific quiz
    public Quiz getQuiz(int index) {
        return quizDao.getQuiz(index);
    }



    //Access Database operations
    private static class InsertQuizAsyncTask extends AsyncTask<Quiz, Void, Void> {
        private QuizDao quizDao;

        private InsertQuizAsyncTask(QuizDao quizDao){
            this.quizDao = quizDao;
        }

        @Override
        protected Void doInBackground(Quiz... quizs){
            quizDao.insert(quizs[0]);
            return null;
        }
    }

    private static class UpdateQuizAsyncTask extends AsyncTask <Quiz, Void, Void>{
        private QuizDao quizDao;

        private UpdateQuizAsyncTask(QuizDao quizDao){
            this.quizDao = quizDao;
        }

        @Override
        protected Void doInBackground(Quiz... quizs){
            quizDao.update(quizs[0]);
            return null;
        }
    }
}

