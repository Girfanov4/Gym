package com.androidstudio.gym;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SpashScreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
        new Handler().postDelayed(new Runnable() {

            @Override

            public void run() {

                Intent mainIntent = new Intent(SpashScreen.this, MainActivity.class);

                SpashScreen.this.startActivity(mainIntent);

                SpashScreen.this.finish();

            }

        }, SPLASH_DISPLAY_LENGHT);
    }
}