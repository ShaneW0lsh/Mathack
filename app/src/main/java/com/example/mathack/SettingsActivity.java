package com.example.mathack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    EditText edNumberOfTasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initViews();
    }

    private void initViews() {
        edNumberOfTasks = findViewById(R.id.edNumberOfTasks);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}