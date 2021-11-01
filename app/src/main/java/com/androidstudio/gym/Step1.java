package com.androidstudio.gym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Step1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);
    }
    public void Click(View view){
        Intent intent = new Intent(Step1.this, Step2.class);
        startActivity(intent);
        finish();
    }
}