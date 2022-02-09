package com.shane.mathack.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shane.mathack.R;


//      TODO:
//      1. rewrite how the power works
//      2. Work on the looks
//      3. write recycle view for history activity
//      4. Fix the "not solved item is shown in the list" bug
//      5. Add ability for the user to modificate depth value through Settings Activity

public class MainActivity extends AppCompatActivity {

    private Button mStartBtn, mSettingsBtn, mExitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TaskSessionActivity.class);
                startActivity(intent);
            }
        });

        mSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        mExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "in development", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        mStartBtn = (Button) findViewById(R.id.mStartBtn);
        mSettingsBtn = (Button) findViewById(R.id.mSettingsBtn);
        mExitBtn = (Button) findViewById(R.id.mExitBtn);
    }
}
