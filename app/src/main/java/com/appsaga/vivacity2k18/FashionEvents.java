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

public class FashionEvents extends AppCompatActivity {
    Animation animation;
    int DELAY = 1000;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_events);
    }

    public void onclick(View v) {

        switch (v.getId()) {
            case R.id.vogue:

                animation = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
                ((ImageButton) findViewById(R.id.vogue)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(FashionEvents.this, Vogue.class));
                    }
                }, DELAY);


                break;
            case R.id.campus:
                animation = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top);
                ((ImageButton) findViewById(R.id.campus)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(FashionEvents.this,CampusPrincess.class));
                    }
                }, DELAY);

                break;
        }
    }


}
