package com.appsaga.vivacity2k18;


import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class SahyogEvents extends AppCompatActivity {
    Animation animation;
    int DELAY = 500;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sahyog_events);
    }

    public void onclick(View v) {

        switch (v.getId()) {
            case R.id.social:

                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.social)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SahyogEvents.this, Social.class));
                    }
                }, DELAY);


                break;
            case R.id.rrr:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.rrr)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SahyogEvents.this, RRR.class));
                    }
                }, DELAY);
                break;

        }
    }


}
