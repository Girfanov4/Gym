package com.androidstudio.gym;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SpashScreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 2000;
    public boolean first = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {

            @Override

            public void run() {

                Intent mainIntent = new Intent(SpashScreen.this, Reports.class);

                SpashScreen.this.startActivity(mainIntent);

                SpashScreen.this.finish();

            }

        }, SPLASH_DISPLAY_LENGHT);

    }

}
