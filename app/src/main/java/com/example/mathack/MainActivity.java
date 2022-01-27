package com.example.mathack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


//TODO:
//      1. rewrite how the power works
//      3. Work on the looks
//      5. Fix the "not solved item is shown in the list" bug
//      6. A HARD ONE: create a random expression generator, which has difficulties in it
//      check: "https://softwareengineering.stackexchange.com/questions/195813/generating-random-math-expression"

public class MainActivity extends AppCompatActivity {

    Button btnStart, bntSettings, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TaskSessionActivity.class);
                startActivity(intent);
            }
        });

        bntSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "in development", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        btnStart = findViewById(R.id.btnStart);
        bntSettings = findViewById(R.id.btnSettings);
        btnExit = findViewById(R.id.btnExit);
    }
}
