package com.example.speedcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvCalcTask;
    private EditText etUserInput;

    private Button btn;

    private String ans;

    private long tries;
    private long maxTries = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCalcTask = findViewById(R.id.tvCalcTask);
        etUserInput = findViewById(R.id.etUserInput);

        ans = "30";
        tries = 0;

        final MediaPlayer dingSound = MediaPlayer.create(this, R.raw.ding);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dingSound.isPlaying()) {
                    dingSound.seekTo(0);
                } else {
                    dingSound.start();
                }
            }
        });

        etUserInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // I'll change the activity and show the history of all tasks
                // if (tries > maxTries) { 
                //     return;
                // }

                if (editable.toString().equals(ans)) {
                    editable.clear();

                    if (dingSound.isPlaying()) {
                        dingSound.seekTo(0);
                    } else {
                        dingSound.start();
                    }

                    updateCalcTask();
                    ++tries;
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
