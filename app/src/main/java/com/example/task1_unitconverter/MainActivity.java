package com.example.task1_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert = (Button) findViewById(R.id.convertBtn);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent convert = new Intent(MainActivity.this, com.example.task1_unitconverter.convert_page.class);
                startActivity(convert);

            }
        });
    }
}