package com.example.task1_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class temperature extends AppCompatActivity {

    EditText inputT;
    Spinner unitT;
    ImageButton back;
    TextView c, f, k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);


        inputT = findViewById(R.id.inputTemp);
        unitT = findViewById(R.id.unitTemp);
        back = findViewById(R.id.back);
        c = findViewById(R.id.c);
        f = findViewById(R.id.f);
        k = findViewById(R.id.k);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
                /*Intent back = new Intent(temperature.this, com.example.task1_unitconverter.convert_page.class);
                startActivity(back);*/
            }
        });

        String[] arr = {"c", "f", "k"};
        unitT.setAdapter(new ArrayAdapter(temperature.this, android.R.layout.simple_list_item_1, arr));

        unitT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        inputT.addTextChangedListener(new TextWatcher() {
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
        if (!inputT.getText().toString().equals("") && !unitT.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(inputT.getText().toString());
            switch (unitT.getSelectedItem().toString()) {
                case "c":
                    setKd(in);
                    break;
                case "f":
                    double e = in - 32;
                    setKd(e * 0.55555555555555555555555556);
                    break;
                case "k":
                    setKd(in - 273.15);
                    break;
            }
        }

    }

    private void setKd(double kd_in) {
        c.setText(String.valueOf(kd_in));
        f.setText(String.valueOf((kd_in * (1.8)) + 32));
        k.setText(String.valueOf(kd_in + 273.15));
    }
}