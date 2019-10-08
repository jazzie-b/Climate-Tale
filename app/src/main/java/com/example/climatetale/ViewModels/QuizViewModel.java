package com.example.climatetale.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.climatetale.Data.Question;
import com.example.climatetale.Repository.QuestionRepository;

import java.util.List;

public class QuizViewModel extends AndroidViewModel {

    private QuestionRepository repository;
    private LiveData<Question> question;
    private List<Question> questions;

    public QuizViewModel(@NonNull Application application) {
        super(application);
        //repository connection
        question = null;
    }

    //get the 3 questions from database - base number then look for 1, 2 , 3

    //Load questions into a list
    public void loadQuestions(){
        //Load questions from database into list
        questions.add(null);
        questions.add(null);
        questions.add(null);
    }

    /*Need to display values to interface
    * - Chapter
    * - Topic Name
    * - Question number
    * - Question
    * - Option 1-4
    * - Selection
    * - Answer
    * - IsCorrect
    * */

    //Get selection from the radio buttons
    //if correct load next question
    //if incorrect reload template - only allow them to move to next questions once correct

    //Load complete screen once completed

}
