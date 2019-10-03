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
import android.widget.Toast;

import com.example.climatetale.Data.UserInfo;
import com.example.climatetale.ViewModels.UserViewModel;


public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureBtnOpenTopic();

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUserInfo().observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo userInfo) {
                Toast.makeText(MainActivity.this, "Observed", Toast.LENGTH_SHORT).show();

            }
        });
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
