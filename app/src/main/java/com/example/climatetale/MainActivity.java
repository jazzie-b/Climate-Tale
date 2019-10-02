package com.example.climatetale;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.climatetale.ViewModels.MainActivityViewModel;


public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureBtnOpenTopic();

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        /*mMainActivityViewModel.init(this);

        final TextView txtName = findViewById(R.id.txtName);
        txtName.setText(mMainActivityViewModel.getUsersName());*/
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
}
