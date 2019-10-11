package com.example.climatetale;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.climatetale.ViewModels.UserViewModel;


public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureBtnOpenTopic();

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        addNameDialog(this);

    }

    //Configure button to move to quiz
    private void configureBtnOpenTopic(){

        Button btnOpenTopic = (Button)findViewById(R.id.btnOpenTopic);

        btnOpenTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //First = current view, Second = intended view
                startActivity(new Intent(MainActivity.this, TopicActivity.class));
            }
        });

    }

    public void addNameDialog(Context c) {
        final EditText editText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Welcome")
                .setMessage("What is your name?")
                .setView(editText)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        name = String.valueOf(editText.getText());
                        userViewModel.updateUserName(name);
                        TextView title = findViewById(R.id.txtName);
                        title.setText("Welcome " + userViewModel.getUserName());
                    }
                })
                .create();
        dialog.show();
    }
}
