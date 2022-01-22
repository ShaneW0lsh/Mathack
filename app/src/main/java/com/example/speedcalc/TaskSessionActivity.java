package com.example.speedcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TaskSessionActivity extends AppCompatActivity {

    private TextView tvCalcTask;
    private EditText etUserInput;
    private TextView txtScore;

    private Button btn;

    private String ans;

    Random rand;

    private long score;
    private long maxScore;
    private int maxOperationAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_session);

        initVariables();


        // btn = findViewById(R.id.button);

        // btn.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View view) {
        //         if (dingSound.isPlaying()) {
        //             dingSound.seekTo(0);
        //         } else {
        //             dingSound.start();
        //         }
        //     }
        // });

        final MediaPlayer dingSound = MediaPlayer.create(this, R.raw.ding);
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

                    if (dingSound.isPlaying()) {
                        dingSound.seekTo(0);
                    } else {
                        dingSound.start();
                    }

                    ++score;
                    txtScore.setText(Long.toString(score));
                    updateCalcTask();

                    if (score == maxScore) {
                        // change current activity
                        System.out.println("worked 2+222");
                        Intent intent = new Intent(TaskSessionActivity.this, TaskHistoryActivity.class);
                        score = 0;
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private void initVariables() {
        rand = new Random();
        ans = "30";
        score = 0;
        maxScore = 5;
        maxOperationsAvailable = 4;

        initViews();
    }

    private void initViews() {
        tvCalcTask = findViewById(R.id.tvCalcTask);
        etUserInput = findViewById(R.id.etUserInput);
        txtScore = findViewById(R.id.txtScore);
    }

    // private int generateOperation() {
        
    // }

    // private void generateOperands() { 

    // }
    
    //TODO
    //finish this
    private Expression generateExpression() {
        Expression expr = new Expression();

        int operation = rand.nextInt(maxOperationsAvailable);
        switch(operation) {
            case 0:
                
            case 1:
            case 3:
            case 4:
        }

        expr.create(fVal, sVal, operation, answer);
        return expr;
    }

    private void updateCalcTask() {
        Expression expression = generateExpression();


        int upperbound = 10;

        int first = rand.nextInt(upperbound), 
            second = rand.nextInt(upperbound), 
            updAnsInt = first * second;

        Expression cExpr = new Expression(Integer.toString(first), Integer.toString(second), "mul", Integer.toString(updAnsInt));
        DataHolder.getInstance().addData(cExpr);

        String updAnsStr = Integer.toString(updAnsInt);
        this.ans = updAnsStr;
        System.out.println(this.ans);

        String toSet = first + " * " + second;
        tvCalcTask.setText(toSet);
    }
}
