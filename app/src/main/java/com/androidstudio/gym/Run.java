package com.androidstudio.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run extends AppCompatActivity {
    TextView tv_digital_clock;
    Typeface tf;
    int mCurrectPeriod = 0;
    private Timer myTimer;
    Boolean isPaused = false;
    int Kcal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);
        Bundle bundle = getIntent().getExtras();
        String scores = bundle.get("scores").toString();


        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button plan = (Button) findViewById(R.id.button16);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Run.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button lessons = (Button) findViewById(R.id.button17);
        lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Run.this, Lessons.class);
                startActivity(intent);
                finish();
            }
        });
        Button profile = (Button) findViewById(R.id.button19);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Run.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });
        ImageView imageView = findViewById(R.id.imageView12);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Run.this, MyRunList.class);
                startActivity(intent);
                finish();
            }
        });
    }


    public void Stop(View view) {

        TextView textView1 = findViewById(R.id.textView53);
        TextView textView2 = findViewById(R.id.textView54);
        Intent intent = new Intent(Run.this, MyRunList.class);
        intent.putExtra("distance", textView1.getText().toString());
        intent.putExtra("timer", textView2.getText().toString());
        startActivity(intent);
    }
}


