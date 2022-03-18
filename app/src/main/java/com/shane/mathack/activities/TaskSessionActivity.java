package com.shane.mathack.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
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


import io.github.kexanie.library.MathView;

public class TaskSessionActivity extends AppCompatActivity {

    private static final String EXTRA_TREE_DEPTH =
            "com.shane.mathack.tree_depth";

    private static final String EXTRA_CONSTRAINT =
            "com.shane.mathack.constraint";

    String colr = "white";
    String expr = "ax^2+bx+c=0";
    String sz = "huge";
    //String ltx = String.format("$$\\color{%s}{\\%s %s}$$", colr, sz, expr);

    private MathView mTaskTextView;
    private TextView mScoreTextView;
    private EditText mInputEditText;

    private String mAnswer;

    private long mScore = 0;

    private String mMaxAns;
    private long mMaxScore = DataHolder.getNumOfTasks();
    private String mDepth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_session);

        String intentConstraint = getIntent().getStringExtra(EXTRA_CONSTRAINT);
        String intentDepth = getIntent().getStringExtra(EXTRA_TREE_DEPTH);
        mMaxAns = isNull(intentConstraint) ? "50" : intentConstraint;
        mDepth = isNull(intentDepth) ? "2" : intentDepth;

        //detect which theme is currently on
        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                //do something
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                //do something
                break;
        }

        initViews();

        setTitle("Training");
        final MediaPlayer dingSound = MediaPlayer.create(this, R.raw.ding);

        updateTask();

        mInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

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

    private boolean isNull(String intentConstraint) {
        if (intentConstraint == null || intentConstraint.isEmpty()) {
            return true;
        }
        return false;
    }

    public static Intent newIntent(Context packageContext, String depth, String constraint) {
        Intent retIntent = new Intent(packageContext, TaskSessionActivity.class);
        retIntent.putExtra(EXTRA_TREE_DEPTH, depth);
        retIntent.putExtra(EXTRA_CONSTRAINT, constraint);
        return retIntent;
    }

    private void initViews() {
        mScoreTextView= (TextView) findViewById(R.id.scoreTextView);
        mTaskTextView = (MathView) findViewById(R.id.taskTextView);
        mInputEditText = (EditText) findViewById(R.id.inputEditText);
    }

    private void updateTask() {
        System.out.println(String.format("%s; %s", mDepth, mMaxAns));
        Expression word = new Expression(Integer.valueOf(mDepth), Integer.valueOf(mMaxAns));
        mTaskTextView.setText(String.format("$$\\color{white}{\\LARGE %s}$$",
                              word.toString()));

        mAnswer = Integer.toString(word.evaluate());
        System.out.println(mAnswer);

        DataHolder.addData(word);
    }
}
