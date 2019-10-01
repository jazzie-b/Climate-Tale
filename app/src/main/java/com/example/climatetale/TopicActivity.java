package com.example.climatetale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TopicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic);
        configureBtnStartQuiz();

    }

    //Configure button to move to quiz
    private void configureBtnStartQuiz(){

        Button btnStartQuiz = (Button)findViewById(R.id.btnStartQuiz);

        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //First = current view, Second = intended view
                startActivity(new Intent(TopicActivity.this, QuizActivity.class));
            }
        });

    }
}
