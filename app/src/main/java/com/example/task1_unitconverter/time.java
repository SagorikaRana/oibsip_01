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

public class time extends AppCompatActivity {

    EditText inputt;
    Spinner unitt;
    ImageButton back;
    TextView s, ms, micros, ns, min, hr, day, wk, mth, yr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        inputt = (EditText) findViewById(R.id.inputT);
        unitt = (Spinner)findViewById(R.id.unitT);
        back = findViewById(R.id.back);
        s = (TextView)findViewById(R.id.s);
        ms = (TextView)findViewById(R.id.ms);
        micros = (TextView)findViewById(R.id.micros);
        ns = (TextView)findViewById(R.id.ns);
        min = (TextView)findViewById(R.id.min);
        hr = (TextView)findViewById(R.id.hr);
        day = (TextView)findViewById(R.id.day);
        wk = (TextView)findViewById(R.id.wk);
        mth = (TextView)findViewById(R.id.mth);
        yr = (TextView) findViewById(R.id.yr);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                /*Intent back = new Intent(time.this, com.example.task1_unitconverter.convert_page.class);
                startActivity(back);*/
            }
        });


        String[] arr = {"s", "ms", "micros", "ns", "min", "hr", "day", "wk", "mth", "yr"};
        unitt.setAdapter(new ArrayAdapter(time.this, android.R.layout.simple_list_item_1, arr));

        unitt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        inputt.addTextChangedListener(new TextWatcher() {
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
        if (!inputt.getText().toString().equals("") && !unitt.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(inputt.getText().toString());
            switch (unitt.getSelectedItem().toString()) {
                case "s":
                    sets(in);
                    break;
                case "ms":
                    sets(in / 1000);
                    break;
                case "micros":
                    sets(in / 1000000);
                    break;
                case "ns":
                    double d = 1000000 * 1000000;
                    sets(in / d);
                    break;
                case "min":
                    sets(in / 0.0166667);
                    break;
                case "hr":
                    sets(in / 0.0002777778);
                    break;
                case "day":
                    double e = 24 * 3600;
                    sets(in * e);
                    break;
                case "wk":
                    double f = 168 * 3600;
                    sets(in * f );
                    break;
                case "mth":
                    double g = 730 * 3600;
                    sets(in * g );
                    break;
                case "yr":
                    double h = 8760 * 3600;
                    sets(in * h );
                    break;
            }
        }
    }

    private void sets(double s_in) {
        s.setText(String.valueOf(s_in));
        ms.setText(String.valueOf(s_in * 1000));
        micros.setText(String.valueOf(s_in * 1000000));
        ns.setText(String.valueOf(s_in * 1000000 * 1000000));
        min.setText(String.valueOf(s_in / 60));
        hr.setText(String.valueOf(s_in /  3600));
        day.setText(String.valueOf(s_in / (24 * 3600)));
        wk.setText(String.valueOf(s_in / (168 * 3600)));
        mth.setText(String.valueOf(s_in / (730 * 3600)));
        yr.setText(String.valueOf(s_in / (8760 * 3600)));
    }
}