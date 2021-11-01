package com.androidstudio.gym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Step2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);
        Button female = (Button) findViewById(R.id.button2);
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Step2.this,Step3_f.class);
                startActivity(intent);
                finish();
            }
        });
        Button male = (Button) findViewById(R.id.button4);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Step2.this,Step3_m.class);
                startActivity(intent);
                finish();
            }
        });
        Button next = (Button) findViewById(R.id.button12);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Step2.this,Step3_m.class);
                startActivity(intent);
                finish();
            }
        });
    }
}