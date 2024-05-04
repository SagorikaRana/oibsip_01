package com.example.task1_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class convert_page extends AppCompatActivity {


    ImageButton back;
    Button length;
    Button weight;
    Button time;
    Button temp;
    Button digital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_page);

        setContentView(R.layout.activity_convert_page);

        back = findViewById(R.id.back);

        length = (Button) findViewById(R.id.length);
        weight = (Button) findViewById(R.id.weight);
        time = (Button) findViewById(R.id.time);
        temp = (Button) findViewById(R.id.temp);
        digital = (Button) findViewById(R.id.digital);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
                /*Intent back = new Intent(convert_page.this,com.example.task1_unitconverter.MainActivity.class);
                startActivity(back);*/
            }
        });


        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentL = new Intent(convert_page.this, com.example.task1_unitconverter.length.class);
                startActivity(intentL);
            }
        });

        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentW = new Intent(convert_page.this, com.example.task1_unitconverter.weight.class);
                startActivity(intentW);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentT = new Intent(convert_page.this, com.example.task1_unitconverter.time.class);
                startActivity(intentT);
            }
        });


        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentT = new Intent(convert_page.this, com.example.task1_unitconverter.temperature.class);
                startActivity(intentT);
            }
        });

        digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentD = new Intent(convert_page.this, com.example.task1_unitconverter.digital.class);
                startActivity(intentD);
            }
        });
    }
}