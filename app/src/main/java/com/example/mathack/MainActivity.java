package com.example.mathack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
                //does nothing for now
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //does nothing for now
            }
        });
    }

    private void initViews() {
        btnStart = findViewById(R.id.btnStart);
        bntSettings = findViewById(R.id.btnSettings);
        btnExit = findViewById(R.id.btnExit);
    }
}
