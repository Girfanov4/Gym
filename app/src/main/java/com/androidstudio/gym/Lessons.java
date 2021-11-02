package com.androidstudio.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lessons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        Button plan = (Button)findViewById(R.id.button16);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lessons.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button profile = (Button)findViewById(R.id.button19);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lessons.this,Profile.class);
                startActivity(intent);
                finish();
            }
        });
    }
}