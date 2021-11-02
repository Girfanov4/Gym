package com.androidstudio.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lessons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        TextView hands = (TextView) findViewById(R.id.tvhands);
        TextView spine = (TextView) findViewById(R.id.tvspine);
        TextView torso = (TextView) findViewById(R.id.tvtorso);
        TextView legs = (TextView) findViewById(R.id.tvlegs);
        Button image1 = (Button)findViewById(R.id.button34);
        Button image2 = (Button)findViewById(R.id.button35);
        Button image3 = (Button)findViewById(R.id.button36);
        Button image4 = (Button)findViewById(R.id.button37);

        Button plan = (Button)findViewById(R.id.button16);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lessons.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button profile = (Button)findViewById(R.id.button19);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lessons.this,Profile.class);
                startActivity(intent);
                finish();
            }
        });

        hands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hands.setBackgroundColor(getResources().getColor(R.color.titleclr));
                spine.setBackgroundColor(getResources().getColor(R.color.white));
                torso.setBackgroundColor(getResources().getColor(R.color.white));
                legs.setBackgroundColor(getResources().getColor(R.color.white));

                hands.setTextColor(getResources().getColor(R.color.white));
                spine.setTextColor(getResources().getColor(R.color.titleclr));
                torso.setTextColor(getResources().getColor(R.color.titleclr));
                legs.setTextColor(getResources().getColor(R.color.titleclr));


                image1.setBackgroundResource(R.drawable.logo_hands);
                image2.setBackgroundResource(R.drawable.logo_hands);
                image3.setBackgroundResource(R.drawable.logo_hands);
                image4.setBackgroundResource(R.drawable.logo_hands);

            }
        });
        spine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hands.setBackgroundColor(getResources().getColor(R.color.white));
                spine.setBackgroundColor(getResources().getColor(R.color.titleclr));
                torso.setBackgroundColor(getResources().getColor(R.color.white));
                legs.setBackgroundColor(getResources().getColor(R.color.white));

                hands.setTextColor(getResources().getColor(R.color.titleclr));
                spine.setTextColor(getResources().getColor(R.color.white));
                torso.setTextColor(getResources().getColor(R.color.titleclr));
                legs.setTextColor(getResources().getColor(R.color.titleclr));


                image1.setBackgroundResource(R.drawable.logo_spine);
                image2.setBackgroundResource(R.drawable.logo_spine);
                image3.setBackgroundResource(R.drawable.logo_spine);
                image4.setBackgroundResource(R.drawable.logo_spine);
            }
        });
        torso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hands.setBackgroundColor(getResources().getColor(R.color.white));
                spine.setBackgroundColor(getResources().getColor(R.color.white));
                torso.setBackgroundColor(getResources().getColor(R.color.titleclr));
                legs.setBackgroundColor(getResources().getColor(R.color.white));

                hands.setTextColor(getResources().getColor(R.color.titleclr));
                spine.setTextColor(getResources().getColor(R.color.titleclr));
                torso.setTextColor(getResources().getColor(R.color.white));
                legs.setTextColor(getResources().getColor(R.color.titleclr));


                image1.setBackgroundResource(R.drawable.logo_torso);
                image2.setBackgroundResource(R.drawable.logo_torso);
                image3.setBackgroundResource(R.drawable.logo_torso);
                image4.setBackgroundResource(R.drawable.logo_torso);
            }
        });
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hands.setBackgroundColor(getResources().getColor(R.color.white));
                spine.setBackgroundColor(getResources().getColor(R.color.white));
                torso.setBackgroundColor(getResources().getColor(R.color.white));
                legs.setBackgroundColor(getResources().getColor(R.color.titleclr));

                hands.setTextColor(getResources().getColor(R.color.titleclr));
                spine.setTextColor(getResources().getColor(R.color.titleclr));
                torso.setTextColor(getResources().getColor(R.color.titleclr));
                legs.setTextColor(getResources().getColor(R.color.white));


                image1.setBackgroundResource(R.drawable.logo_legs);
                image2.setBackgroundResource(R.drawable.logo_legs);
                image3.setBackgroundResource(R.drawable.logo_legs);
                image4.setBackgroundResource(R.drawable.logo_legs);
            }
        });
    }
}