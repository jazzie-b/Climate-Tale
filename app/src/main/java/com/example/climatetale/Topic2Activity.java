package com.example.climatetale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Topic2Activity extends AppCompatActivity {

    Button menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic2);

        //set up view elements
        setUpMenuBtn();
    }

    //set up button to return to menu
    private void setUpMenuBtn(){
        menuBtn = findViewById(R.id.btnReturnMenu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Topic2Activity.this, MainActivity.class));
            }
        });
    }
}
