package com.example.climatetale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureBtnStartQuiz();

    }

    //Configure button to move to quiz
    private void configureBtnStartQuiz(){

        Button btnStartQuiz = (Button)findViewById(R.id.btnStartQuiz);

        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //First = current view, Second = intended view
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
            }
        });

    }
}
