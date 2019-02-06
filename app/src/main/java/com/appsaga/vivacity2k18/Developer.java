package com.appsaga.vivacity2k18;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Developer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
    }

    @Override
    public void onBackPressed() {
            finish();

    }
    public void alink(View v){
        String socialNetwork = "https://www.linkedin.com/in/ayush-gupta-1983b0144/";
        startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse(socialNetwork)), "Open with:"));
    }
    public void acall(View v){

        String phone = "+919460323512";
        Intent ayush= new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(ayush);
    }
    public  void agit(View v){
        String socialNetwork = "https://github.com/17ucs042";
        startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse(socialNetwork)), "Open with:"));
    }

    public void mlink(View v){
        String socialNetwork = "https://www.linkedin.com/in/mayank-aggarwal-574901110";
        startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse(socialNetwork)), "Open with:"));
    }
    public void mcall(View v){

        String phone = "+919460560912";
        Intent mayank= new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(mayank);}
    public  void mgit(View v){

        String socialNetwork = "https://github.com/aggarwalmayank";
        startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse(socialNetwork)), "Open with:"));

    }
}
