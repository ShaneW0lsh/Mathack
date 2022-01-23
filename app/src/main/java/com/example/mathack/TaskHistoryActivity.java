package com.example.mathack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TaskHistoryActivity extends AppCompatActivity {

    private final ArrayList<Expression> expressions = DataHolder.getData();

    private ListView expressionsList;

    public void onShowTaskHistory() {
        for (Expression expr : expressions) {
            System.out.println(expr.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_history);

        initViews();

        ArrayList<Expression> dataExpr = DataHolder.getData();
        ArrayList<String> dataStr = new ArrayList<>();
        
        for (Expression expr : dataExpr) {
            dataStr.add(expr.toString());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(
                this, R.layout.text_centered, R.id.textItem, dataStr);

        expressionsList.setAdapter(dataAdapter);
    }

    @Override
    protected void onDestroy() {
        DataHolder.clearData();
        Intent intent = new Intent(TaskHistoryActivity.this, MainActivity.class);
        startActivity(intent);
        super.onDestroy();
    }

    private void initViews() { 
        expressionsList = findViewById(R.id.expressionsList);
    }
}
