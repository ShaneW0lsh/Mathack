package com.example.mathack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    
    //TODO
    //finish this
    private Expression generateExpression() {
        Expression expr = new Expression();

        int operationInt = rand.nextInt(maxOperationsAvailable);
        long answer;
        String operationStr;
        switch(operationInt) {
            case 0:
                operationStr = "+"; 
                int[2] operands = generateOperands(300);
                answer = operands[0] + operands[1];
            case 1:
                operationStr = "-"; 
                int[2] operands = generateOperands(300);
                answer = operands[0] - operands[1];
            case 2:
                operationStr = "*"; 
                int[2] operands = generateOperands(26);
                answer = operands[0] * operands[1];
            case 3:
                operationStr = ":"; 
                int[2] operands = generateOperands(300, true);
                answer = operands[0] / operands[1];
        }

        expr.create(String.valueOf(operands[0]), String.valueOf(operands[1]), operationStr, String.valueOf(answer));
        return expr;
    }

    private int[2] generateOperands(int upperBound, boolean isDivisible = false) {
        int[2] ret;

        ret[0] = random.nextInt(upperBound);
        
        if (isDivisible) {
            while (true) {
                ret[1] = random.nextInt(ret[0] + 1);
                if (ret[1] != 0 and ret[0] % ret[1] == 0) {
                    break;
                }
                System.out.println(ret[0] + ' ' + ret[1]);
            }
        } else {
            ret[1] = random.nextInt(upperBound);
        }

        return ret;
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
