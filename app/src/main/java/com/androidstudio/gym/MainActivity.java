package com.androidstudio.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button lessons = (Button)findViewById(R.id.button17);
        lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Lessons.class);
                startActivity(intent);
                finish();
            }
        });
        Button reports = (Button)findViewById(R.id.button18);
        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Reports.class);
                startActivity(intent);
                finish();
            }
        });
        Button profile = (Button)findViewById(R.id.button19);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Profile.class);
                startActivity(intent);
                finish();
            }
        });
        Button pushupsmeu = (Button)findViewById(R.id.button23);
        pushupsmeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PushUpsMenu.class);
                startActivity(intent);
                finish();
            }
        });
        Button situp = (Button)findViewById(R.id.button30);
        situp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SitUpMenu.class);
                startActivity(intent);
                finish();
            }
        });
        Button trunkinclinations = (Button)findViewById(R.id.button24);
        trunkinclinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TrunkInclinationsMenu.class);
                startActivity(intent);
                finish();
            }
        });
        Button legs = (Button)findViewById(R.id.button33);
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RunMenu.class);
                startActivity(intent);
                finish();
            }
        });
    }
}