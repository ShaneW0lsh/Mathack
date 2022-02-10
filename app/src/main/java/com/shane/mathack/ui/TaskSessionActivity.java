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

    private TextView mTaskTextView;
    private TextView mScoreTextView;
    private EditText mUIEditText;

    private String mAnswer;

    private long mScore = 0;
    final private long mMaxScore = DataHolder.getNumOfTasks();
    final private int mDepth = DataHolder.getDepth();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_session);

        initViews();

        final MediaPlayer dingSound = MediaPlayer.create(this, R.raw.ding);

        updateTask();

        mUIEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals(mAnswer)) {
                    editable.clear();

                    if (dingSound.isPlaying()) {
                        dingSound.seekTo(0);
                    } else {
                        dingSound.start();
                    }

                    ++mScore;
                    mScoreTextView.setText(Long.toString(mScore));
                    updateTask();

                    if (mScore == mMaxScore) {
                        Intent intent = new Intent(TaskSessionActivity.this, TaskHistoryActivity.class);
                        mScore = 0;
                        startActivity(intent);
                        TaskSessionActivity.this.finish();
                    }
                }
            }
        });
    }

    private void initViews() {
        mTaskTextView = findViewById(R.id.mTaskTextView);
        mUIEditText = findViewById(R.id.mUIEditText);
        mScoreTextView= findViewById(R.id.mScoreTextView);
    }

    private void updateTask() {
        Expression word = new Expression(mDepth, 1000);
        mTaskTextView.setText(word.toString());

        mAnswer = Integer.toString(word.evaluate());
        System.out.println(mAnswer);

        DataHolder.addData(word);
    }    
}
