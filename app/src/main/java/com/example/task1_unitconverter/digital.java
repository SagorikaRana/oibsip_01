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

public class digital extends AppCompatActivity {
    EditText inputD;
    Spinner unitD;
    ImageButton back;
    TextView bi, by, kb, kib,mb,meb, gb, gib,tb, teb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital);


        inputD = findViewById(R.id.inputD);
        unitD = findViewById(R.id.unitD);
        back = findViewById(R.id.back);
        bi = findViewById(R.id.bi);
        by = findViewById(R.id.by);
        kb = findViewById(R.id.kb);
        kib = findViewById(R.id.kib);
        mb = findViewById(R.id.mb);
        meb = findViewById(R.id.meb);
        gb = findViewById(R.id.gb);
        gib = findViewById(R.id.gib);
        tb = findViewById(R.id.tb);
        teb = findViewById(R.id.teb);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        String[] arr = {"bi", "by", "kb", "kib","mb","meb", "gb", "gib","tb", "teb"};
        unitD.setAdapter(new ArrayAdapter(digital.this, android.R.layout.simple_list_item_1, arr));

        unitD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        inputD.addTextChangedListener(new TextWatcher() {
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
        if (!inputD.getText().toString().equals("") && !unitD.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(inputD.getText().toString());
            switch (unitD.getSelectedItem().toString()) {
                case "bi":
                    double d = 8000 * 1000;
                    setKd(in / d);
                    break;
                case "by":
                    double e = 1000 * 1000;
                    setKd(in / e);
                    break;
                case "kb":
                    setKd(in / 1000);
                    break;
                case "kib":
                    setKd(in / 976.563);
                    break;
                case "mb":
                    setKd(in);
                    break;
                case "meb":
                    setKd(in * 1.04858);
                    break;
                case "gb":
                    setKd(in * 1000);
                    break;
                case "gib":
                    setKd(in * 1073.74);
                    break;
                case "tb":
                    setKd(in * 1000000);
                    break;
                case "teb":
                    setKd(in * 1100000);
                    break;
            }
        }

    }

    private void setKd(double kd_in) {
        bi.setText(String.valueOf(kd_in * 8000 * 1000));
        by.setText(String.valueOf(kd_in * 1000 * 1000));
        kb.setText(String.valueOf(kd_in * 1000));
        kib.setText(String.valueOf(kd_in * 976.563));
        mb.setText(String.valueOf(kd_in));
        meb.setText(String.valueOf(kd_in / 1.04858));
        gb.setText(String.valueOf(kd_in / 1000));
        gib.setText(String.valueOf(kd_in / 1073.74));
        tb.setText(String.valueOf(kd_in / 1000000));
        teb.setText(String.valueOf(kd_in / 1100000));

    }
}