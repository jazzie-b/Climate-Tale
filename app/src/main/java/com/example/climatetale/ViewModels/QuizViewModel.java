package com.example.climatetale.ViewModels;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.climatetale.Data.Question;
import com.example.climatetale.Data.Quiz;
import com.example.climatetale.Repository.QuestionRepository;
import com.example.climatetale.Repository.QuizRepository;
import com.example.climatetale.Repository.UserRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class QuizViewModel extends AndroidViewModel {

    private QuestionRepository questionRepository;
    private QuizRepository quizRepository;
    private int quizID;
    private int chapterID;
    private int questionID;
    private Question question;
    private ArrayList<Question> questionList;

    public QuizViewModel(@NonNull Application application) {
        super(application);
        //Variables
        //1 = Chapter, 01 = Topic, 01 = quiz
        chapterID = 1;
        quizID = 10101;
        questionID = quizID*10 + 1; //101011
        //repository connection
        quizRepository = new QuizRepository(application, quizID);
        questionRepository = new QuestionRepository(application, questionID);
    }

    //get the 3 questions from database - base number then look for 1, 2 , 3

    //Load questions into the list
    public void loadQuestions(){
        questionList = questionRepository.populateQuestionList();
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

    //Get QuizName to display
    public String getQuizName(int index){
        Log.d("quiz", "HERE");
        int currentQuizID = questionList.get(index).quizID;
        String quizName = quizRepository.getQuiz(currentQuizID).quizName;


        return quizName;
    }

    //Create chapter name label (without accessing database)
    public String getChapterName(){
        String chapterName = "Chapter " + chapterID;

        return  chapterName;
    }

    //get question number in a label
    public String getQuestionNumber(int index){
        //current position + 1 as index starts at 0
        int questionNumber = index + 1;
        String questionLabel = "Question " + questionNumber;

        return questionLabel;
    }

    //return current question
    public String getCurrentQuestion(int index){
        String currentQuestion = questionList.get(index).question;

        return currentQuestion;
    }

    //return list of options to display in radio buttons
    public ArrayList<String> getCurrentOptions(int index){
        //Empty array list
        ArrayList<String> currentOptions = new ArrayList<>();

        //get options
        String opt1 = questionList.get(index).option1;
        String opt2 = questionList.get(index).option2;
        String opt3 = questionList.get(index).option3;
        String opt4 = questionList.get(index).option4;

        //add options to arraylist
        currentOptions.add(opt1);
        currentOptions.add(opt2);
        currentOptions.add(opt3);
        currentOptions.add(opt4);

        return currentOptions;
    }

    public void setAnswer(){

    }

    public void checkAnswer(){


    }


    //Get selection from the radio buttons
    //if correct load next question
    //if incorrect reload template - only allow them to move to next questions once correct

    //Load complete screen once completed

}
