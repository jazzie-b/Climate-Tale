package com.example.climatetale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import com.example.climatetale.ViewModels.QuizViewModel;

public class QuizActivity extends AppCompatActivity {

    QuizViewModel quizViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_question);

        quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);

        quizViewModel.loadQuestions();
        setView(0);

    }

    public void setView(int index){
        //Get Fields
        TextView quizName = findViewById(R.id.txtName);

        //set the fields
        quizName.setText(quizViewModel.getQuizName(index));

    }

}
