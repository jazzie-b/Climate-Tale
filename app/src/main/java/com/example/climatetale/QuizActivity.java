package com.example.climatetale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.climatetale.Data.ClimateTaleDatabase;
import com.example.climatetale.Data.Question;

import java.util.ArrayList;


public class QuizActivity extends AppCompatActivity {

    ArrayList<Question> questionList;
    ArrayList<String> options;
    TextView txtChapterName;
    TextView txtTopicName;
    TextView txtQuestionNum;
    TextView txtQuestion;
    RadioGroup optionRadio;
    RadioButton opt1;
    RadioButton opt2;
    RadioButton opt3;
    RadioButton opt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_question);
        txtChapterName = findViewById(R.id.txtChapter);
        txtTopicName = findViewById(R.id.txtTopicName);
        txtQuestionNum = findViewById(R.id.txtQuestionNum);
        txtQuestion = findViewById(R.id.txtQuestion);
        optionRadio = findViewById(R.id.options);
        opt1 = findViewById(R.id.option1);
        opt2 = findViewById(R.id.option2);
        opt3 = findViewById(R.id.option3);
        opt4 = findViewById(R.id.option4);

        //Create arrayList and populate it
        questionList = new ArrayList<>();
        populateList();

        //Start Quiz
        doQuiz();

    }

    //Do quiz
    public void doQuiz(){
        int index = 0;

        //repeat until finished (no more questions
        //set view
        setView(index);
        //getAnswer();
        //save answers;
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
    */

    public void setView(int index){
        //Get current required question
        Question currentQ = questionList.get(index);

        //Get IDs
        int quizID = questionList.get(index).quizID;
        int topicID = ClimateTaleDatabase.getInstance(getApplicationContext()).quizDao().getTopicID(quizID);
        int chapterID = ClimateTaleDatabase.getInstance(getApplicationContext()).topicDao().getChapterID(topicID);

        //Get values needed to display
        int chapterNum = ClimateTaleDatabase.getInstance(getApplicationContext()).chapterDao().getChapterNumber(chapterID);
        int topicNum= ClimateTaleDatabase.getInstance(getApplicationContext()).topicDao().getTopicNumber(topicID);
        String topicName= ClimateTaleDatabase.getInstance(getApplicationContext()).topicDao().getTopicName(topicID);
        options = new ArrayList<>();
        options.add(questionList.get(index).option1);
        options.add(questionList.get(index).option2);
        options.add(questionList.get(index).option3);
        options.add(questionList.get(index).option4);

        //set up interface
        int questionNum = index+1;


        //Set values to interface
        txtChapterName.setText("CHAPTER " + chapterNum);
        txtTopicName.setText("TOPIC" + topicNum + ": " + topicName.toUpperCase());
        txtQuestionNum.setText("QUESTION " + questionNum);
        txtQuestion.setText(questionList.get(index).question);

        //need to set radio buttons
        opt1.setText(options.get(0));
        opt2.setText(options.get(1));
        opt3.setText(options.get(2));
        opt4.setText(options.get(3));

    }

    public void populateList(){
        //Quiz ID = 10101, Question ID = 101011, 101012, 101013
        int questionID = 101011;
        Question currentQ;

        //populate list
        for(int i = 0; i < 3; i++){
            //Get currentQuestion
            currentQ = ClimateTaleDatabase.getInstance(getApplicationContext()).questionDao().getQuestionObj(questionID);
            //add to list
            questionList.add(currentQ);
            //Increment
            questionID = questionID + 1;
        }

    }

    public static int getAnswer(){
        return 1;
    }

}
