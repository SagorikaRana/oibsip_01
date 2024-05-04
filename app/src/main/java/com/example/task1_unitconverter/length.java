package com.example.task1_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class length extends AppCompatActivity {


    EditText inputl;
    Spinner unitl;
    ImageButton back;
    TextView km, m, cm, mm, microm, nm, mile, yard, foot, inch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        inputl = findViewById(R.id.inputl);
        unitl = findViewById(R.id.unitl);
        back = findViewById(R.id.back);
        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        cm = findViewById(R.id.cm);
        mm = findViewById(R.id.mm);
        microm = findViewById(R.id.microm);
        nm = findViewById(R.id.nm);
        mile = findViewById(R.id.mile);
        yard = findViewById(R.id.yard);
        foot = findViewById(R.id.foot);
        inch = findViewById(R.id.inch);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
/*
                Intent back = new Intent(length.this, com.example.task1_unitconverter.convert_page.class);
                startActivity(back);*/
            }
        });

        String[] arr = {"km", "m", "cm", "mm", "microm", "nm", "mile", "yard", "foot", "inch"};
        unitl.setAdapter(new ArrayAdapter(length.this, android.R.layout.simple_list_item_1, arr));

        unitl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        inputl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update();
            }
        });
    }

    private void update() {
        if (!inputl.getText().toString().equals("") && !unitl.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(inputl.getText().toString());
            switch (unitl.getSelectedItem().toString()) {
                case "km":
                    setKm(in);
                    break;
                case "m":
                    setKm(in / 1000);
                    break;
                case "cm":
                    setKm(in / 100000);
                    break;
                case "mm":
                    setKm(in / 1000000);
                    break;
                case "microm":
                    setKm(in / 1000000000);
                    break;
                case "nm":
                    double d = 1000000 * 1000000;
                    setKm(in / d);
                    break;
                case "mile":
                    setKm(in * 1.609);
                    break;
                case "yard":
                    setKm(in / 1094);
                    break;
                case "foot":
                    setKm(in / 3281);
                    break;
                case "inch":
                    setKm(in / 39370);
                    break;
            }
        }
    }

    private void setKm(double km_in) {
        km.setText(String.valueOf(km_in));
        m.setText(String.valueOf(km_in * 1000));
        cm.setText(String.valueOf(km_in * 100000));
        mm.setText(String.valueOf(km_in * 1000000));
        microm.setText(String.valueOf(km_in * 1000000000));
        nm.setText(String.valueOf(km_in * 1000000 * 1000000));
        mile.setText(String.valueOf(km_in / 1.609));
        yard.setText(String.valueOf(km_in * 1094));
        foot.setText(String.valueOf(km_in * 3281));
        inch.setText(String.valueOf(km_in * 39370));
    }
}