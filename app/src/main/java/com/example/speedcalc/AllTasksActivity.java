package com.example.speedcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class AllTasksActivity extends AppCompatActivity {

    private final ArrayList<Expression> expressions = DataHolder.getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);
    }

    @Override
    protected void onDestroy() {
        DataHolder.clearData();
        super.onDestroy();
    }

    public void onShowTaskHistory() {
        for (Expression expr : expressions) {
            System.out.println(expr.toString());
        }
    }
}
