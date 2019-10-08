package com.example.climatetale.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.climatetale.Data.ClimateTaleDatabase;
import com.example.climatetale.Data.Question;
import com.example.climatetale.Data.QuestionDao;


public class QuestionRepository {
    private QuestionDao questionDao;
    private LiveData<Question> question;

    public QuestionRepository(Application application, int questionID){
        //Connect to database
        ClimateTaleDatabase db = ClimateTaleDatabase.getInstance(application);
        //Get dao
        questionDao = db.getQuestionDao();
        question = questionDao.getQuestionObj(questionID);
    }

    //Database operations
    //Database operations
    public void insert(Question question){
        new QuestionRepository.InsertQuestionAsyncTask(questionDao).execute(question);
    }

    public void update(Question question){
        new QuestionRepository.UpdateQuestionAsyncTask(questionDao).execute(question);
    }

    //Live data objects methods
    public LiveData<Question> getQuestion() {
        return question;
    }


    //Access Database operations
    private static class InsertQuestionAsyncTask extends AsyncTask<Question, Void, Void> {
        private QuestionDao questionDao;

        private InsertQuestionAsyncTask(QuestionDao questionDao){
            this.questionDao = questionDao;
        }

        @Override
        protected Void doInBackground(Question... questions){
            questionDao.insert(questions[0]);
            return null;
        }
    }

    private static class UpdateQuestionAsyncTask extends AsyncTask<Question, Void, Void>{
        private QuestionDao questionDao;

        private UpdateQuestionAsyncTask(QuestionDao questionDao){
            this.questionDao = questionDao;
        }

        @Override
        protected Void doInBackground(Question... questions){
            questionDao.update(questions[0]);
            return null;
        }
    }

}
