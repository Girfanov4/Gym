package com.androidstudio.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Push_ups extends AppCompatActivity {
    TextView tv_digital_clock;
    Typeface tf;

    int mCurrectPeriod = 0;
    private Timer myTimer;
    Boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_ups);
        tv_digital_clock = (Button) findViewById(R.id.button32);
        tv_digital_clock.setTypeface(tf);
        Button plan = (Button)findViewById(R.id.button16);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Push_ups.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button lessons = (Button)findViewById(R.id.button17);
        lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Push_ups.this,Lessons.class);
                startActivity(intent);
                finish();
            }
        });
        Button profile = (Button)findViewById(R.id.button19);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Push_ups.this,Profile.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Вы действительно хотите покинуть программу?")
                .setCancelable(false)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Push_ups.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("Нет", null).show();
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
            mCurrectPeriod = 0;
            if (myTimer != null)
                myTimer.cancel();
            isPaused = false;
            TextView textViewminutes = (TextView)findViewById(R.id.textView38) ;
            textViewminutes.setText(tv_digital_clock.getText().toString());
            tv_digital_clock.setText("Succes");
            tv_digital_clock.setEnabled(true);
        }
    }


}