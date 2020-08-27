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

import com.example.climatetale.Data.*;


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

        //set database instance
        ClimateTaleDatabase climateTaleDB = ClimateTaleDatabase.getInstance(getApplicationContext());

        //Hide titles
        txtTitle = findViewById(R.id.txtName);
        txtTopic = findViewById(R.id.txtTopic);
        txtTopic.setVisibility(View.INVISIBLE);
        btnOpenTopic = (Button)findViewById(R.id.btnOpenTopic);
        btnOpenTopic.setVisibility(View.INVISIBLE);

        //Configure buttons
        configureBtnOpenChapter();
        configureBtnOpenTopic();

        //Get name in db
        String name = climateTaleDB.userInfoDao().getName(1);

        //in name in db is default ask the user for their name
        if (name.equals("HELLO WORLD")) {
            askName(climateTaleDB);
        }
        //if name in db isn't default, then display the name
        if (!name.equals("HELLO WORLD")){
            displayName(climateTaleDB);
        }

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
    private void askName(ClimateTaleDatabase climateTaleDB) {
        //Ask question
        addNameDialog(this, climateTaleDB);
    }

    //Opens up dialog to ask users name
    public void addNameDialog(Context c, final ClimateTaleDatabase climateTaleDB) {
        final EditText editText = new EditText(c);
        //create alert box
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Welcome")
                .setMessage("What is your name?")
                .setView(editText)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //gets users name and displays it
                        name = String.valueOf(editText.getText());
                        climateTaleDB.userInfoDao().updateName(name, 1);
                        displayName(climateTaleDB);
                    }
                })
                .create();
        dialog.show();

    }

    //display the users name on the title screen
    public void displayName(ClimateTaleDatabase climateTaleDB){
        String currName = climateTaleDB.userInfoDao().getName(1);
        txtTitle.setText("Welcome " + currName);
    }
}
