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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic2);

        setUpMenuBtn();
    }

    public void setUpMenuBtn(){
        menuBtn = findViewById(R.id.btnReturnMenu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Topic2Activity.this, MainActivity.class));
            }
        });
    }
}
