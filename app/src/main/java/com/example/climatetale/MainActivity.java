package com.example.climatetale;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.climatetale.Data.Answer;
import com.example.climatetale.Data.AppInfo;
import com.example.climatetale.Data.Chapter;
import com.example.climatetale.Data.ClimateTaleDatabase;
import com.example.climatetale.Data.Question;
import com.example.climatetale.Data.Quiz;
import com.example.climatetale.Data.Topic;
import com.example.climatetale.Data.UserInfo;


public class MainActivity extends AppCompatActivity {

    public String name;
    public TextView txtTitle;
    public TextView txtTopic;
    public Button btnOpenTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hide titles
        txtTitle = findViewById(R.id.txtName);
        txtTopic = findViewById(R.id.txtTopic);
        txtTopic.setVisibility(View.INVISIBLE);
        btnOpenTopic = (Button)findViewById(R.id.btnOpenTopic);
        btnOpenTopic.setVisibility(View.INVISIBLE);

        //Populate database (need to happen only once)
        populateDatabase();

        //Configure buttons
        configureBtnOpenChapter();
        configureBtnOpenTopic();

        //ask users name
        askName();

    }

    //Add items to DB
    public void populateDatabase(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                //AppInfo
                AppInfo appInfo = new AppInfo(1, 3,1);
                ClimateTaleDatabase.getInstance(getApplicationContext()).appInfoDao().insert(appInfo);
                //UserInfo
                UserInfo userInfo = new UserInfo(1,
                        "HELLO WORLD", 0,0,
                        0,1);
                ClimateTaleDatabase.getInstance(getApplicationContext()).userInfoDao().insert(userInfo);
                //Chapter
                Chapter chapter = new Chapter(1, 1,
                        "What is Climate Change?", 1,
                        false);
                ClimateTaleDatabase.getInstance(getApplicationContext()).chapterDao().insert(chapter);
                //Topic
                Topic topic = new Topic(101, 1,
                        "CO₂ in Atmosphere",1,false);
                ClimateTaleDatabase.getInstance(getApplicationContext()).topicDao().insert(topic);
                //Quiz
                Quiz quiz = new Quiz(10101,"Topic 1: CO2 in the Atmosphere",
                        101,false);
                ClimateTaleDatabase.getInstance(getApplicationContext()).quizDao().insert(quiz);
                //Questions
                Question question = new Question(101011,10101,
                        "What layer of the atmosphere does weather occur?",
                        "Stratosphere",
                        "Troposphere",
                        "Mesosphere",
                        "Exosphere",
                        0);
                ClimateTaleDatabase.getInstance(getApplicationContext()).questionDao().insert(question);
                question = new Question(101012,10101,
                        "What is the most abundant gas in our atmosphere?",
                        "Nitrogen",
                        "Oxygen",
                        "Carbon Dioxide",
                        "Helium",
                        0);
                ClimateTaleDatabase.getInstance(getApplicationContext()).questionDao().insert(question);
                question = new Question(101013,10101,
                        "What type of gas is carbon dioxide?",
                        "Greenhouse Gas",
                        "Laughing Gas",
                        "Natural Gas",
                        "Greyhouse Gas",
                        0);
                ClimateTaleDatabase.getInstance(getApplicationContext()).questionDao().insert(question);
                //Answers
                Answer answer = new Answer(1010111,
                        101011,2,false);
                ClimateTaleDatabase.getInstance(getApplicationContext()).answerDao().insert(answer);
                answer = new Answer(1010121,
                        101012,1,false);
                ClimateTaleDatabase.getInstance(getApplicationContext()).answerDao().insert(answer);
                answer = new Answer(1010131,
                        101013,1,false);
                ClimateTaleDatabase.getInstance(getApplicationContext()).answerDao().insert(answer);
            }
        }).start();
    }

    //Configure btn to show topics
    private void configureBtnOpenChapter(){
        final Button btnOpenChapter = (Button)findViewById(R.id.btnChapter1);

        btnOpenChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open to topic menu
                txtTopic.setVisibility(View.VISIBLE);
                btnOpenTopic.setVisibility(View.VISIBLE);

            }
        });
    }

    //Configure button to move to topic page
    private void configureBtnOpenTopic(){

        btnOpenTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open to topic
                startActivity(new Intent(MainActivity.this, TopicActivity.class));
            }
        });

    }

    //Get users name
    private void askName() {
        //Ask question
        addNameDialog(this);
    }

    //Opens up dialog to ask users name
    public void addNameDialog(Context c) {
        final EditText editText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Welcome")
                .setMessage("What is your name?")
                .setView(editText)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //gets users name and displays it
                        name = String.valueOf(editText.getText());
                        ClimateTaleDatabase.getInstance(getApplicationContext()).userInfoDao().updateName(name, 1);
                        String currName = ClimateTaleDatabase.getInstance(getApplicationContext()).userInfoDao().getName(1);
                        txtTitle.setText("Welcome " + currName);
                    }
                })
                .create();
        dialog.show();
    }
}
