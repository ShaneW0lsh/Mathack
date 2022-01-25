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
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class TaskSessionActivity extends AppCompatActivity {

    private TextView tvCalcTask;
    private EditText etUserInput;
    private TextView txtScore;

    private String ans;

    Random rand;

    private long score;
    private long maxScore;
    private int maxOperationsAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_session);

        initVariables();

        final MediaPlayer dingSound = MediaPlayer.create(this, R.raw.ding);

        updateCalcTask();

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
                        Intent intent = new Intent(TaskSessionActivity.this, TaskHistoryActivity.class);
                        score = 0;
                        startActivity(intent);
                        TaskSessionActivity.this.finish();
                    }
                }
            }
        });
    }

    private void initVariables() {
        rand = new Random();
        score = 0;
        maxScore = DataHolder.getInstance().getNumOfTasks();
        maxOperationsAvailable = 4;

        initViews();
    }

    private void initViews() {
        tvCalcTask = findViewById(R.id.tvCalcTask);
        etUserInput = findViewById(R.id.etUserInput);
        txtScore = findViewById(R.id.txtScore);
    }
    
    private Expression generateExpression() {
        Expression expr = new Expression();

        int operationInt = rand.nextInt(maxOperationsAvailable);
        long answer;
        String operationStr = "";
        ArrayList<Integer> operands = new ArrayList<>();
        switch(operationInt) {
            case 0:
                operationStr = "+"; 
                generateOperands(300, false, operands);
                answer = operands.get(0) + operands.get(1);
                break;
            case 1:
                operationStr = "-"; 
                generateOperands(300, false, operands);
                answer = operands.get(0) - operands.get(1);
                break;
            case 2:
                operationStr = "*"; 
                generateOperands(26, false, operands);
                answer = operands.get(0) * operands.get(1);
                break;
            case 3:
                operationStr = ":"; 
                generateOperands(200, true, operands);
                answer = operands.get(0) / operands.get(1);
                break;
            default:
                Toast.makeText(this, "error in 'generateExpression()' method", Toast.LENGTH_LONG).show();
                generateOperands(26, false, operands);
                answer = 0;
        }

        expr.create(String.valueOf(operands.get(0)), String.valueOf(operands.get(1)), operationStr, String.valueOf(answer));
        return expr;
    }

    private void generateOperands(int upperBound, boolean isDivisible, ArrayList<Integer> operands) {
        ArrayList<Integer> divisors = new ArrayList<>();

        operands.add(rand.nextInt(upperBound));
        
        if (isDivisible) {
            generateDivisors(operands.get(0), divisors);
            int idx = rand.nextInt(divisors.size());
            operands.add(divisors.get(idx));
        } else {
            operands.add(rand.nextInt(upperBound));
        }
    }

    private ArrayList<Integer> generateDivisors(int num, ArrayList<Integer> divisors) {
        for (int i = 1; i * i <= num; ++i) {
            if (num % i == 0) {
                divisors.add(i);
                if (num / i != i) {
                    divisors.add(num / i);
                }
            }
        }

        return divisors;
    }

    private void updateCalcTask() {
        Expression expression = generateExpression();
        this.ans = expression.getAnswer();

        DataHolder.getInstance().addData(expression);

        String toSet = expression.toString();
        tvCalcTask.setText(toSet);

        System.out.println(this.ans);
    }
}
