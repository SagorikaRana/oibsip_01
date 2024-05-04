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

public class weight extends AppCompatActivity {

    EditText inputw;
    Spinner unitw;
    ImageButton back;
    TextView kg, gm, mgm, microgm, ngm, usT, ton, st, pou, oun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        inputw = findViewById(R.id.inputw);
        unitw = findViewById(R.id.unitw);
        back = findViewById(R.id.back);
        kg = findViewById(R.id.kg);
        gm = findViewById(R.id.gm);
        mgm = findViewById(R.id.mgm);
        microgm = findViewById(R.id.microgm);
        ngm = findViewById(R.id.ngm);
        usT = findViewById(R.id.usT);
        ton = findViewById(R.id.ton);
        st = findViewById(R.id.stn);
        pou = findViewById(R.id.pou);
        oun = findViewById(R.id.oun);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
                /*Intent back = new Intent(weight.this, com.example.task1_unitconverter.convert_page.class);
                startActivity(back);*/
            }
        });


        String[] arra = {"kg", "gm", "mgm", "microgm", "ngm", "US Ton", "Tonne", "Stone", "Pound", "Ounce"};
        ArrayAdapter<String> unitWadap = new ArrayAdapter<>(
                weight.this,
                android.R.layout.simple_list_item_1,
                arra
        );
        unitw.setAdapter(new ArrayAdapter(weight.this, android.R.layout.simple_list_item_1, arra));

        unitw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                updateW();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        inputw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                updateW();
            }
        });
    }

    private void updateW() {
        if (!inputw.getText().toString().equals("") && !unitw.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(inputw.getText().toString());
            switch (unitw.getSelectedItem().toString()) {
                case "kg":
                    setKg(in);
                    break;
                case "gm":
                    setKg(in / 1000);
                    break;
                case "mgm":
                    setKg(in / 1000000);
                    break;
                case "microgm":
                    setKg(in / 1000000000);
                    break;
                case "ngm":
                    double d = 1000000 * 1000000;
                    setKg(in / d);
                    break;
                case "US Ton":
                    setKg(in * 907.2);
                    break;
                case "Tonne":
                    setKg(in / 1000);
                    break;
                case "Stone":
                    setKg(in * 6.35);
                    break;
                case "Pound":
                    setKg(in / 2.205);
                    break;
                case "Ounce":
                    setKg(in / 35.27);
                    break;
            }
        }
    }

    private void setKg(double kg_in) {
        kg.setText(String.valueOf(kg_in));
        gm.setText(String.valueOf(kg_in * 1000));
        mgm.setText(String.valueOf(kg_in * 1000000));
        microgm.setText(String.valueOf(kg_in * 1000000000));
        ngm.setText(String.valueOf(kg_in * 1000000 * 1000000));
        usT.setText(String.valueOf(kg_in / 907.2));
        ton.setText(String.valueOf(kg_in / 1000));
        st.setText(String.valueOf(kg_in / 6.35));
        pou.setText(String.valueOf(kg_in * 2.205));
        oun.setText(String.valueOf(kg_in * 35.27));
    }

}