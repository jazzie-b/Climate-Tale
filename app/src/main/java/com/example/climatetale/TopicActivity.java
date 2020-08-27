package com.example.climatetale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.climatetale.Data.ClimateTaleDatabase;

public class TopicActivity extends AppCompatActivity {

    //Variables
    public TextView txtChapterTitle;
    public TextView txtTopicTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic);

        //set database instance
        ClimateTaleDatabase climateTaleDB = ClimateTaleDatabase.getInstance(getApplicationContext());

        //configure view
        configureTitles(climateTaleDB);
        configureBtnStartQuiz();
    }

    //configure titles for layout
    private void configureTitles(ClimateTaleDatabase climateTaleDB) {
        //Get IDs
        int topicID = 101;
        int chapterID = climateTaleDB.topicDao().getChapterID(topicID);

        //Get values needed to display
        int chapterNum = climateTaleDB.chapterDao().getChapterNumber(chapterID);
        int topicNum = climateTaleDB.topicDao().getTopicNumber(topicID);
        String topicName = climateTaleDB.topicDao().getTopicName(topicID);

        //find text views and update content
        txtChapterTitle = findViewById(R.id.txtChapterTitle);
        txtTopicTitle = findViewById(R.id.txtTopicTitle);

        txtChapterTitle.setText("CHAPTER " + chapterNum);
        txtTopicTitle.setText("TOPIC " + topicNum + ":\n" + topicName.toUpperCase());
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
