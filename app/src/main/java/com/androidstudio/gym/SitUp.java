package com.androidstudio.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SitUp extends AppCompatActivity {
    TextView tv_digital_clock;
    Typeface tf;

    int mCurrectPeriod = 0;
    private Timer myTimer;
    Boolean isPaused = false;
    int Kcal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sit_up);

        Bundle bundle = getIntent().getExtras();
        String scores = bundle.get("scores").toString();
        TextView textViewscores = findViewById(R.id.textView36);
        textViewscores.setText(scores);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv_digital_clock = (Button) findViewById(R.id.button32);
        tv_digital_clock.setTypeface(tf);
        Button plan = (Button) findViewById(R.id.button16);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SitUp.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button lessons = (Button) findViewById(R.id.button17);
        lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SitUp.this, Lessons.class);
                startActivity(intent);
                finish();
            }
        });
        Button profile = (Button) findViewById(R.id.button19);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SitUp.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });
    }


    public void onStartButtonClick(View view) {

        if (!isPaused) {
            myTimer = new Timer();
            myTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    TimerMethod();
                }
            }, 0, 1000);
            TextView textViewscores = findViewById(R.id.textView36);
            Integer integer = Integer.parseInt(textViewscores.getText().toString());
            textViewscores.setText(Integer.toString(integer - 1));
            tv_digital_clock.setEnabled(false);
        }
    }

    private void TimerMethod() {
        this.runOnUiThread(Timer_Tick);
    }

    private Runnable Timer_Tick = new Runnable() {
        @Override
        public void run() {
            if (!isPaused) {
                mCurrectPeriod++;
                String temp = (new SimpleDateFormat("mm:ss")).format(new Date(mCurrectPeriod * 1000));
                tv_digital_clock.setText(temp);
            }
        }
    };

    public void onStopButtonClick(View view) {
        isPaused = !isPaused;
        if (isPaused = false) {
            isPaused = !isPaused;
        } else {
            Kcal = mCurrectPeriod;
            mCurrectPeriod = 0;
            if (myTimer != null)
                myTimer.cancel();
            isPaused = false;

            tv_digital_clock.setEnabled(true);
            TextView textViewscores = findViewById(R.id.textView36);
            Integer scores = Integer.parseInt(textViewscores.getText().toString());
            Intent intent = new Intent(SitUp.this, SitUpStop.class);
            intent.putExtra("minutes", tv_digital_clock.getText().toString());
            intent.putExtra("scores", textViewscores.getText().toString());
            intent.putExtra("kcal", Integer.toString(Kcal/scores));
            startActivity(intent);
            finish();
        }
    }


}