package com.vsga.calculator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etFirst;
    EditText etSecond;
    TextView tvOperations;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOperations = findViewById(R.id.tvOperations);
        tvResult = findViewById(R.id.tvResult);

        Button btnClear = findViewById(R.id.btnClear);

        etFirst = findViewById(R.id.etFirstNumber);
        etSecond = findViewById(R.id.etSecondNumber);

        TextView tvPlus = findViewById(R.id.tvPlus);
        TextView tvMinus = findViewById(R.id.tvMinus);
        TextView tvTimes = findViewById(R.id.tvTimes);
        TextView tvDivision = findViewById(R.id.tvDivision);

        tvPlus.setOnClickListener(v -> operations(1));
        tvMinus.setOnClickListener(v -> operations(2));
        tvTimes.setOnClickListener(v -> operations(3));
        tvDivision.setOnClickListener(v -> operations(4));

        btnClear.setOnClickListener(v -> {
            tvResult.setText("");
            tvOperations.setText("");
            etFirst.setText("");
            etSecond.setText("");
        });
    }

    private void operations(int operation) {
        String num1Txt = etFirst.getText().toString().trim();
        String num2Txt = etSecond.getText().toString().trim();
        String numOperation = "";

        double num1 = 0;
        double num2 = 0;

        try {
            num1 = Double.parseDouble(num1Txt);
            num2 = Double.parseDouble(num2Txt);
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }

        double result = 0;

        try {
            switch (operation) {
                case 1:
                    result = num1 + num2;
                    numOperation = "\u002b";
                    break;
                case 2:
                    result = num1 - num2;
                    numOperation = "\u2212";
                    break;
                case 3:
                    result = num1 * num2;
                    numOperation = "\u2a2f";
                    break;
                case 4:
                    result = num1 / num2;
                    numOperation = "\u00F7";
                    break;
            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }

        tvResult.setText(String.valueOf(result));
        tvOperations.setText(String.format("%s %s %s", num1, numOperation, num2));
    }
}