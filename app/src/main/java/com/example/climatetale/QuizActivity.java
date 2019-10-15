package com.example.climatetale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.climatetale.Data.ClimateTaleDatabase;
import com.example.climatetale.Data.Question;
import com.example.climatetale.Data.Quiz;

import java.util.ArrayList;


public class QuizActivity extends AppCompatActivity {

    //variables
    ArrayList<Question> questionList;
    ArrayList<String> options;
    int index = 0;
    int answer = 0;
    int selectedAnswer = 0;

    //view object
    TextView txtChapterName;
    TextView txtTopicName;
    TextView txtQuestionNum;
    TextView txtQuestion;
    TextView txtFeedback;

    RadioGroup optionRadio;
    RadioButton opt1;
    RadioButton opt2;
    RadioButton opt3;
    RadioButton opt4;

    Button btnNextQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_question);

        txtChapterName = findViewById(R.id.txtChapter);
        txtTopicName = findViewById(R.id.txtTopicName);
        txtQuestionNum = findViewById(R.id.txtQuestionNum);
        txtQuestion = findViewById(R.id.txtQuestion);
        txtFeedback = findViewById(R.id.txtFeedback);
        optionRadio = findViewById(R.id.options);
        opt1 = findViewById(R.id.option1);
        opt2 = findViewById(R.id.option2);
        opt3 = findViewById(R.id.option3);
        opt4 = findViewById(R.id.option4);
        btnNextQ = findViewById(R.id.btnNext);

        //Create arrayList and populate it
        questionList = new ArrayList<>();
        populateList();

        setNextQuestionBtn();

        //Start Quiz
        doQuiz();

    }

    public void setNextQuestionBtn(){

        btnNextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get current question id and turn it into an answerID
                int answerID = questionList.get(index).questionID *10 + 1;

                //get correct answer and users answer
                selectedAnswer = checkAnswer();
                answer = ClimateTaleDatabase.getInstance(getApplicationContext()).answerDao().getAnswer(answerID);

                //check users answer against correct answer
                if(answer == selectedAnswer){
                    //if correct check there are more questions to load and load them
                    index++;
                    if(index < 3) {
                        doQuiz();
                    }else{
                        //if not more answers, update progress to display in chart
                        ClimateTaleDatabase.getInstance(getApplicationContext()).userInfoDao().updateOverallProgress(1,1);
                        ClimateTaleDatabase.getInstance(getApplicationContext()).userInfoDao().updateOverallTopic(1, 1);
                        //load final screen
                        startActivity(new Intent(QuizActivity.this, QuizFinishedActivity.class));
                    }
                }else{
                    //if answer is incorrect, inform user
                    txtFeedback.setVisibility(View.VISIBLE);
                    txtFeedback.setText("Answer is incorrect, try again");
                    txtFeedback.setTextColor(Color.RED);
                }
            }
        });
    }

    //Do quiz
    public void doQuiz() {
        //set question
        setView(index);
    }


    //Set view as current question
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
        txtTopicName.setText("TOPIC " + topicNum + ": " + topicName.toUpperCase());
        txtQuestionNum.setText("QUESTION " + questionNum);
        txtQuestion.setText(questionList.get(index).question);
        txtFeedback.setVisibility(View.INVISIBLE);

        //need to set radio buttons
        opt1.setText(options.get(0));
        opt2.setText(options.get(1));
        opt3.setText(options.get(2));
        opt4.setText(options.get(3));

    }

    public void populateList(){
        //Quiz ID = 10101, Question ID = 101011, 101012, 10101
        Question currentQ;
        int questionID = 101011;

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

    public int checkAnswer(){
        //get selected button
        int selectedRadio = optionRadio.getCheckedRadioButtonId();
        RadioButton answer = findViewById(selectedRadio);

        int selected = 0;

        String message;

        //check which option was selected
        if(answer.getId() == opt1.getId()){
            selected = 1;
            message = String.valueOf(selected);
            Log.d("SELECTED: ", message);
        }else if(answer.getId() == opt2.getId()){
            selected = 2;
            message = String.valueOf(selected);
            Log.d("SELECTED: ", message);
        }else if(answer.getId() == opt3.getId()){
            selected = 3;
            message = String.valueOf(selected);
            Log.d("SELECTED: ", message);
        }else{
            selected = 4;
            message = String.valueOf(selected);
            Log.d("SELECTED: ", message);
        }

        return selected;
    }

}
