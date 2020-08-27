package com.example.climatetale;


import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.climatetale.Data.ClimateTaleDatabase;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class QuizFinishedActivity extends AppCompatActivity {

    Button btnNextTopic;
    PieChart pieChartResults;
    int totalTopics;
    int progressTopics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_finish);

        //set database instance
        ClimateTaleDatabase climateTaleDB = ClimateTaleDatabase.getInstance(getApplicationContext());

        //set up Pie Chart
        setUpPieChart(climateTaleDB);

        //set up labels
        String userName = climateTaleDB.userInfoDao().getName(1);
        TextView txtCongrats = findViewById(R.id.txtCongrats);
        txtCongrats.setText("Congratulations\n" + userName + "!\nYou passed the quiz.");
        totalTopics = climateTaleDB.appInfoDao().getTotalTopics(1);
        progressTopics = climateTaleDB.userInfoDao().getProgressTopic(1);
        TextView txtStatus = findViewById(R.id.txtStatus);
        txtStatus.setText("You have completed\n" + progressTopics + " topic(s) out of " + totalTopics + " in chapter 1");

        //next topic
        getNextTopic();
    }

    //create pie chart
    private void setUpPieChart(ClimateTaleDatabase climateTaleDB) {

        //get chart and set properties
        PieChart pieChartResult = findViewById(R.id.pieChart);

        //allow a hole
        pieChartResult.setDrawHoleEnabled(true);
        pieChartResult.setHoleColor(android.R.color.white);
        //set only half a circle
        pieChartResult.setMaxAngle(180f);
        //remove extra hole line
        pieChartResult.setTransparentCircleAlpha(0);
        //remove movement
        pieChartResult.setTouchEnabled(false);
        pieChartResult.setRotation(270f);

        //hide legend
        Legend pieChartLegend = pieChartResult.getLegend();
        pieChartLegend.setEnabled(false);

        //hide description
        Description pieChartDes = pieChartResult.getDescription();
        pieChartDes.setEnabled(false);

        //get total amount of topics, progress and calculate percentage left to complete
        totalTopics = climateTaleDB.appInfoDao().getTotalTopics(1);
        progressTopics = climateTaleDB.userInfoDao().getProgressTopic(1);
        int progressLeft = totalTopics - progressTopics;

        //add two required values to dataset for chart
        ArrayList<PieEntry> progressValues = new ArrayList<>();

        progressValues.add(new PieEntry(progressTopics));
        progressValues.add(new PieEntry(progressLeft));

        //create dataset and set properties
        PieDataSet dataSet = new PieDataSet(progressValues, "");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setDrawValues(false);

        //Add data to chart
        PieData data = new PieData(dataSet);
        pieChartResult.setData(data);

    }

    //load next chapter
    private void getNextTopic(){
        btnNextTopic = findViewById(R.id.btnNextTopic);

        btnNextTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizFinishedActivity.this, Topic2Activity.class));
            }
        });
    }
}
