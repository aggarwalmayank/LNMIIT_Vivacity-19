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

public class MusicEvents extends AppCompatActivity {
    Animation animation;
    int DELAY = 500;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_events);
    }

    public void onclick(View v) {

        switch (v.getId()) {
            case R.id.solendious:

                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.solendious)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MusicEvents.this, Solendious.class));
                    }
                }, DELAY);


                break;
            case R.id.mescolanza:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.mescolanza)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MusicEvents.this, Mescolanza.class));
                    }
                }, DELAY);


                break;
            case R.id.verismo:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.verismo)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MusicEvents.this, Verismo.class));
                    }
                }, DELAY);

                break;
            case R.id.swaranjali:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.swaranjali)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MusicEvents.this, Swaranjali.class));
                    }
                }, DELAY);

                break;
            case R.id.duetsong:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.duetsong)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MusicEvents.this, Duetto.class));
                    }
                }, DELAY);

                break;
            case R.id.antakshari:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.antakshari)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MusicEvents.this, Antakshari.class));
                    }
                }, DELAY);

                break;
            case R.id.rap:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.rap)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MusicEvents.this, RapBattle.class));
                    }
                }, DELAY);

                break;
        }
    }


}
