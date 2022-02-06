package com.shane.mathack.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.shane.mathack.util.DataHolder;
import com.shane.mathack.util.expression.Expression;
import com.shane.mathack.R;

import java.util.ArrayList;

public class TaskHistoryActivity extends AppCompatActivity {

    private final ArrayList<Expression> expressions = DataHolder.getData();

    private ListView expressionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_history);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        DataHolder.clearData();
        // Intent intent = new Intent(TaskHistoryActivity.this, MainActivity.class);
        // startActivity(intent);
        super.onDestroy();
    }

    public void onShowTaskHistory() {
        for (Expression expr : expressions) {
            System.out.println(expr.toString());
        }
    }

    private void initViews() { 
        expressionsList = findViewById(R.id.expressionsList);
    }
}
