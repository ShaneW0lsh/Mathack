package com.shane.mathack.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.shane.mathack.util.DataHolder;
import com.shane.mathack.R;

public class SettingsActivity extends AppCompatActivity {

    EditText mNumEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initViews();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initViews() {
        mNumEditText = findViewById(R.id.mNumEditText);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        String numOfTasks = mNumEditText.getText().toString();

        if (!numOfTasks.isEmpty()) {
            int numOfTasksInt = Integer.valueOf(numOfTasks);
            DataHolder.getInstance().setNumOfTasks(numOfTasksInt);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
