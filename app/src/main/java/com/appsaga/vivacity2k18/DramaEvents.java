package com.appsaga.vivacity2k18;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class DramaEvents extends AppCompatActivity {
    Animation animation;
    int DELAY = 500;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drama_events);
    }

    public void onclick(View v) {

        switch (v.getId()) {
            case R.id.rangshala:

                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.rangshala)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DramaEvents.this, RangManch.class));
                    }
                }, DELAY);



                break;
            case R.id.mime:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.mime)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DramaEvents.this,MukhAbhinaya.class));
                    }
                }, DELAY);


                break;
        }
    }


}
