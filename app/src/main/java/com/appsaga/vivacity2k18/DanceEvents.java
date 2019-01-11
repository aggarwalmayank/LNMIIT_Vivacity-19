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

public class DanceEvents extends AppCompatActivity {
    Animation animation;
    int DELAY = 1000;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance_events);
    }

    public void onclick(View v) {

        switch (v.getId()) {
            case R.id.tangle:

                animation = AnimationUtils.loadAnimation(this, R.anim.righttoleft);
                ((ImageButton) findViewById(R.id.tangle)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DanceEvents.this, Tangle.class));
                    }
                }, DELAY);


                break;
            case R.id.mudra:
                animation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
                ((ImageButton) findViewById(R.id.mudra)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DanceEvents.this, Mudra.class));
                    }
                }, DELAY);
                break;
            case R.id.razz:
                animation = AnimationUtils.loadAnimation(this, R.anim.righttoleft);
                ((ImageButton) findViewById(R.id.razz)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DanceEvents.this, Razzmatazz.class));
                    }
                }, DELAY);

                break;
            case R.id.pump:
                animation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
                ((ImageButton) findViewById(R.id.pump)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DanceEvents.this, PumpItUp.class));
                    }
                }, DELAY);

                break;
            case R.id.outlaw:
                animation = AnimationUtils.loadAnimation(this, R.anim.righttoleft);
                ((ImageButton) findViewById(R.id.outlaw)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DanceEvents.this, TheOutlaw.class));
                    }
                }, DELAY);
                break;
        }
    }


}
