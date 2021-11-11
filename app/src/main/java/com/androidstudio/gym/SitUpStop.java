package com.androidstudio.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SitUpStop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sit_up_stop);
        Bundle bundle = getIntent().getExtras();
        String scores = bundle.get("scores").toString();
        String minutes = bundle.get("minutes").toString();
        String kcal = bundle.get("kcal").toString();
        TextView textViewscores = findViewById(R.id.textView47);
        TextView textViewminutes = findViewById(R.id.textView49);
        TextView textViewkcal = findViewById(R.id.textView51);
        textViewscores.setText(scores);
        textViewkcal.setText(kcal);
        textViewminutes.setText(minutes);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}