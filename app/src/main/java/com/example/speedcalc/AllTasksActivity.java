package com.example.speedcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AllTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);
        
        ArayList<Expression> expressions = new ArrayList<>();
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            expressions = extras.get
        onShowTaskHistory();
    }

    public void onShowTaskHistory() { 

    }
}