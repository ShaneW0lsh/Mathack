package com.example.speedcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvCalcTask;
    private EditText etUserInput;

    private String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCalcTask = findViewById(R.id.tvCalcTask);
        etUserInput = findViewById(R.id.etUserInput);

        ans = "30";

        etUserInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals(ans)) {
                    editable.clear();
                    System.out.println("Correct!");
                    updateCalcTask();
                }
            }
        });
    }

    private void updateCalcTask() {
        int upperbound = 25;
        Random rand = new Random();

        int first = rand.nextInt(upperbound);
        int second = rand.nextInt(upperbound);
        int updAnsInt = first * second;

        String updAnsStr = Integer.toString(updAnsInt);
        this.ans = updAnsStr;
        System.out.println(this.ans);

        String toSet = first + " * " + second;

        tvCalcTask.setText(toSet);
    }
}
