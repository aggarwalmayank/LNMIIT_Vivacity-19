package com.appsaga.vivacity2k18;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    //VideoView vid;
    //MediaController m;
    //String path = "raw/viva_vid2.3gp";

    String LOG_TAG= MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFormat(PixelFormat.UNKNOWN);


        int DELAY = 2500;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, com.appsaga.vivacity2k18.First.class);
                startActivity(intent);
                finish();
            }
        }, DELAY);
    }
}
