package com.androidstudio.gym;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button signout = (Button) findViewById(R.id.button28);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, SignIn.class);
                startActivity(intent);
                finish();
            }
        });
        Button plan = (Button) findViewById(R.id.button16);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button lessons = (Button) findViewById(R.id.button17);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Lessons.class);
                startActivity(intent);
                finish();
            }
        });
        Button biometric = (Button) findViewById(R.id.button25);
        biometric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Didn't test it but this should work "out of the box" */

                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                //you should edit this to fit your needs
                builder.setTitle("Biometric");
                builder.setMessage("Please, Input Your Biometric Data");
                final EditText weight = new EditText(Profile.this);
                weight.setHint("Weight");//optional
                final EditText height = new EditText(Profile.this);
                height.setHint("Height");//optional

                //in my example i use TYPE_CLASS_NUMBER for input only numbers
                weight.setInputType(InputType.TYPE_CLASS_NUMBER);
                height.setInputType(InputType.TYPE_CLASS_NUMBER);

                LinearLayout lay = new LinearLayout(Profile.this);
                lay.setOrientation(LinearLayout.VERTICAL);
                lay.addView(weight);
                lay.addView(height);
                builder.setView(lay);

                // Set up the buttons
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //get the two inputs
                        TextView weighttv = (TextView) findViewById(R.id.textView30);
                        weighttv.setText(weight.getText().toString());

                        TextView heighttv = (TextView) findViewById(R.id.textView32);
                        heighttv.setText(height.getText().toString());

                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }

        });
    }
}

