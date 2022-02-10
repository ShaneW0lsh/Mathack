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
    EditText mDepthEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initViews();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initViews() {
        mNumEditText = (EditText) findViewById(R.id.mNumEditText);
        mDepthEditText = (EditText) findViewById(R.id.mDepthEditText);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        String numOfTasks = mNumEditText.getText().toString();
        String depth =  mDepthEditText.getText().toString();
        
        if (!numOfTasks.isEmpty()) {
            int tmp = Integer.valueOf(numOfTasks);
            DataHolder.getInstance().setNumOfTasks(tmp);
        }

        if (!depth.isEmpty()) { 
           int tmp = Integer.valueOf(depth);
           DataHolder.getInstance().setDepth(tmp);
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
