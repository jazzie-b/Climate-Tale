package com.example.climatetale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;


public class QuizActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_question);

        setView(0);

    }

    public void setView(int index){
        //Get Fields
        TextView quizName = findViewById(R.id.txtName);

        //set the fields


    }

}
