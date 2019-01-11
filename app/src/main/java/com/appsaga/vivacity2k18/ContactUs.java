package com.appsaga.vivacity2k18;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

public class ContactUs extends AppCompatActivity {

    //private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    FlowingDrawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        setupToolbar();
        setupMenu();

        /*drawerLayout=findViewById(R.id.drawer2);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       /* NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                drawerLayout.closeDrawers();

                int id= menuItem.getItemId();

                switch(id)
                {
                    case R.id.events:
                        goToEvent();
                        break;
                    case R.id.map:
                        goToMap();
                        break;
                    case R.id.onGoing:
                        goToOnGoing();
                        break;
                    case R.id.pronite:
                        goToPronites();
                        break;
                    case R.id.funEvents:
                        goToFunEvents();
                        break;
                    case R.id.sponsor:
                        goToSponsor();
                        break;
                    case R.id.team:
                        goToTeam();
                        break;
                    case R.id.contact:
                        goToContactUs();
                        break;
                    case R.id.developer:
                        goToDeveloper();
                        break;
                }
                return true;
            }
        });*/

        mDrawer = findViewById(R.id.drawerlayout);
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.i("MainActivity", "Drawer STATE_CLOSED");
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
                Log.i("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
        });
    }

    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        NavigationFragment mMenuFragment = (NavigationFragment) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new NavigationFragment();
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }

//        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
//            @Override
//            public void onDrawerStateChange(int oldState, int newState) {
//                if (newState == ElasticDrawer.STATE_CLOSED) {
//                    Log.i("MainActivity", "Drawer STATE_CLOSED");
//                }
//            }
//
//            @Override
//            public void onDrawerSlide(float openRatio, int offsetPixels) {
//                Log.i("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
//            }
//        });
    }

    protected void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.menudrawer);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.toggleMenu();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isMenuVisible()) {
            mDrawer.closeMenu();
        } else {
            finish();
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void openmap(View view) {
        Uri gmmIntentUri = Uri.parse("geo:26.936346,75.923523");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void callateet(View view) {
        String phone = "+919001757535";
        Intent ateet = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(ateet);
    }

    public void callprabhat(View view) {
        String phone = "+917006638382";
        Intent prabhat = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(prabhat);
    }

    public void sendmail(View view) {
        Intent gmail = new Intent(Intent.ACTION_SENDTO);
        gmail.setData(Uri.parse("mailto:vivacity2k19@gmail.com"));
        if (gmail.resolveActivity(getPackageManager()) != null) {
            startActivity(gmail);
        }
    }

    public void openweb(View view) {
        String url = "https://www.vivacity.lnmiit.ac.in";
        Intent website = new Intent(Intent.ACTION_VIEW);
        website.setData(Uri.parse(url));
        startActivity(website);
    }
}
