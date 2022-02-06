package com.shane.mathack.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.shane.mathack.R;
import com.shane.mathack.util.DataHolder;
import com.shane.mathack.util.expression.Expression;

public class TaskSessionActivity extends AppCompatActivity {

    private TextView tvCalcTask;
    private EditText etUserInput;
    private TextView txtScore;

    private String ans;

    private long score;
    private long maxScore;

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
        score = 0;
        maxScore = DataHolder.getInstance().getNumOfTasks();

        initViews();
    }

    private void initViews() {
        tvCalcTask = findViewById(R.id.tvCalcTask);
        etUserInput = findViewById(R.id.etUserInput);
        txtScore = findViewById(R.id.txtScore);
    }

    private void updateCalcTask() {
        Expression word = new Expression(3, 1000);
        tvCalcTask.setText(word.toString());

        this.ans = Integer.toString(word.evaluate());
        System.out.println(this.ans);

        DataHolder.getInstance().addData(word);
    }    
}
