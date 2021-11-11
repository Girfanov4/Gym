package com.androidstudio.gym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Step5 extends AppCompatActivity {
public String heighttxt,weighttxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step5);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button next = (Button) findViewById(R.id.button14);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Step5.this, Profile.class);

                EditText height = (EditText) findViewById(R.id.editTextNumber3);
                EditText weight = (EditText) findViewById(R.id.editTextNumber4);
                heighttxt=height.getText().toString();
                weighttxt=weight.getText().toString();
                Intent intent1 = new Intent(Step5.this, SignIn.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}