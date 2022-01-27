package com.example.mathack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    EditText edNumberOfTasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initViews();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initViews() {
        edNumberOfTasks = findViewById(R.id.edNumberOfTasks);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        String nOfTasks = edNumberOfTasks.getText().toString();

        if (!nOfTasks.isEmpty()) {
            int nOfTasksInt = Integer.valueOf(nOfTasks);
            DataHolder.getInstance().setNumOfTasks(nOfTasksInt);
        }
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
}
