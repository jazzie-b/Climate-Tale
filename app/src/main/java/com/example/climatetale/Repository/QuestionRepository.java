package com.example.climatetale.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.climatetale.Data.ClimateTaleDatabase;
import com.example.climatetale.Data.Question;
import com.example.climatetale.Data.QuestionDao;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class QuestionRepository {
    private QuestionDao questionDao;
    private Question question;
    private int questionID;

    public QuestionRepository(Application application, int questID){
        //Connect to database
        ClimateTaleDatabase db = ClimateTaleDatabase.getInstance(application);
        //Get dao
        questionDao = db.getQuestionDao();
        questionID = questID;
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
    public Question getQuestion() {
        return question;
    }

    public ArrayList<Question> populateQuestionList(){
        ArrayList<Question> questionList = new ArrayList<>();
        //get ID
        int ID2 = questionID + 1;
        int ID3 = questionID + 2;

        //get 3 questions
        Question question1 = question;
        Question question2 = questionDao.getQuestionObj(ID2);
        Question question3 = questionDao.getQuestionObj(ID3);

        //add to list
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);

        return questionList;
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
