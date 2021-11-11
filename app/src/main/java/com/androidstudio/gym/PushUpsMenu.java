package com.androidstudio.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PushUpsMenu extends AppCompatActivity {
    float i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_ups_menu);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        AdvancedTextView advancedTextView = (AdvancedTextView) findViewById(R.id.progressBar);
        advancedTextView.setValue(i);
        Button plan = (Button) findViewById(R.id.button16);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PushUpsMenu.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button profile = (Button) findViewById(R.id.button19);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PushUpsMenu.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });
        Button lessons = (Button) findViewById(R.id.button17);
        lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PushUpsMenu.this, Lessons.class);
                startActivity(intent);
                finish();
            }
        });


    }


    public void Click(View view) {
        TextView tv = (TextView) view;

            if (tv.getCurrentTextColor() == getResources().getColor(R.color.titleclr)) {
                i = (float) (i + 1.666666666666667);
                AdvancedTextView advancedTextView = (AdvancedTextView) findViewById(R.id.progressBar);
                advancedTextView.setValue(i);

                tv.setBackgroundResource(R.drawable.crug_blue);
                tv.setTextColor(getResources().getColor(R.color.white));
                Intent intent = new Intent(PushUpsMenu.this, Push_ups.class);
                intent.putExtra("scores", tv.getText().toString());
                startActivity(intent);

            }


    }
}