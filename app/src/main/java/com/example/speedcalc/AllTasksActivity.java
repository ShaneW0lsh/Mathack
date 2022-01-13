package com.example.speedcalc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AllTasksActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_all_tasks);

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
        Intent intent = new Intent(AllTasksActivity.this, MainActivity.class);
        startActivity(intent);
        super.onDestroy();
    }

    private void initViews() { 
        expressionsList = findViewById(R.id.expressionsList);
    }
}
