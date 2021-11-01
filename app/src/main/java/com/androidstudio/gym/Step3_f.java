package com.androidstudio.gym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Step3_f extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3_f);
    }
    public void Click(View view){
        Intent intent = new Intent(Step3_f.this,Step4.class);
        startActivity(intent);
        finish();
    }
}