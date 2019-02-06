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

public class ArtEvents extends AppCompatActivity {
    Animation animation;
    int DELAY = 500;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_events);
    }

    public void onclick(View v) {

        switch (v.getId()) {
            case R.id.splash:

                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.splash)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ArtEvents.this, Splash.class));
                    }
                }, DELAY);


                break;
            case R.id.tattoo:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.tattoo)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ArtEvents.this, Tattoo.class));
                    }
                }, DELAY);
                break;
            case R.id.contrasto:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.contrasto)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ArtEvents.this, Contrasto.class));
                    }
                }, DELAY);

                break;
            case R.id.colorama:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.colorama)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ArtEvents.this, Colorama.class));
                    }
                }, DELAY);


                break;
            case R.id.tshirt:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
                ((ImageButton) findViewById(R.id.tshirt)).startAnimation(animation);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ArtEvents.this, Inkthetee.class));
                    }
                }, DELAY);


                break;
        }
    }
    public void open(View view){
        String url = "www.vivacity.netlify.com/forms/regdance";
        Intent website = new Intent(Intent.ACTION_VIEW);
        website.setData(Uri.parse(url));
        startActivity(website);
    }


}
