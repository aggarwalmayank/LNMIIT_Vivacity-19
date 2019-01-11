package com.appsaga.vivacity2k18;

import android.content.Intent;
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
import com.ramotion.foldingcell.FoldingCell;

public class Team extends AppCompatActivity {

    //private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    FlowingDrawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

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

        final FoldingCell tc1 = (FoldingCell) findViewById(R.id.tc1);
        final FoldingCell tc2 = (FoldingCell) findViewById(R.id.tc2);
        final FoldingCell tc3 = (FoldingCell) findViewById(R.id.tc3);
        final FoldingCell tc4 = (FoldingCell) findViewById(R.id.tc4);
        final FoldingCell tc5 = (FoldingCell) findViewById(R.id.tc5);
        final FoldingCell tc6 = (FoldingCell) findViewById(R.id.tc6);
        final FoldingCell tc7 = (FoldingCell) findViewById(R.id.tc7);
        final FoldingCell tc8 = (FoldingCell) findViewById(R.id.tc8);
        final FoldingCell tc9 = (FoldingCell) findViewById(R.id.tc9);
        final FoldingCell tc10 = (FoldingCell) findViewById(R.id.tc10);

        tc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc1.toggle(false);
            }
        });
        tc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc2.toggle(false);
            }
        });
        tc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc3.toggle(false);
            }
        });
        tc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc4.toggle(false);
            }
        });
        tc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc5.toggle(false);
            }
        });
        tc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc6.toggle(false);
            }
        });
        tc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc7.toggle(false);
            }
        });
        tc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc8.toggle(false);
            }
        });
        tc9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc9.toggle(false);
            }
        });
        tc10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc10.toggle(false);
            }
        });
    }


    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        NavigationFragment mMenuFragment = (NavigationFragment)fm.findFragmentById(R.id.id_container_menu);
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

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
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
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
