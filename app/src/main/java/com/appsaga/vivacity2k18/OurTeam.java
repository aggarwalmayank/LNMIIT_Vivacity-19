package com.appsaga.vivacity2k18;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.ramotion.foldingcell.FoldingCell;

public class OurTeam extends AppCompatActivity {

    FlowingDrawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_team);
        final FoldingCell tc1 = (FoldingCell) findViewById(R.id.tc1);
        final FoldingCell tc2 = (FoldingCell) findViewById(R.id.tc2);
        final FoldingCell tc3 = (FoldingCell) findViewById(R.id.tc3);
        final FoldingCell tc4 = (FoldingCell) findViewById(R.id.tc4);
        final FoldingCell tc25 = (FoldingCell) findViewById(R.id.tc25);
        final FoldingCell tc6 = (FoldingCell) findViewById(R.id.tc6);
        final FoldingCell tc7 = (FoldingCell) findViewById(R.id.tc7);
        final FoldingCell tc5 = (FoldingCell) findViewById(R.id.tc5);
        final FoldingCell tc9 = (FoldingCell) findViewById(R.id.tc9);
        final FoldingCell tc10 = (FoldingCell) findViewById(R.id.tc10);
        final FoldingCell tc11 = (FoldingCell) findViewById(R.id.tc11);
        final FoldingCell tc16 = (FoldingCell) findViewById(R.id.tc16);
        final FoldingCell tc15 = (FoldingCell) findViewById(R.id.tc15);
        final FoldingCell tc19 = (FoldingCell) findViewById(R.id.tc19);
        final FoldingCell tc18 = (FoldingCell) findViewById(R.id.tc18);
        final FoldingCell tc17 = (FoldingCell) findViewById(R.id.tc17);
        final FoldingCell tc20 = (FoldingCell) findViewById(R.id.tc20);
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
        tc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc4.toggle(false);
            }
        });
        tc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc6.toggle(false);
            }
        });
        tc11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc11.toggle(false);
            }
        });

        tc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc5.toggle(false);
            }
        });
        tc9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc9.toggle(false);
            }
        });
        tc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc3.toggle(false);
            }
        });
        tc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc7.toggle(false);
            }
        });

        tc10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc10.toggle(false);
            }
        });

        tc18 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc18.toggle(false);
            }
        });

        tc20 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc20.toggle(false);
            }
        });

        tc15 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc15.toggle(false);
            }
        });

        tc25 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc25.toggle(false);
            }
        });

        tc19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc19.toggle(false);
            }
        });
        tc17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc17.toggle(false);
            }
        });
        tc16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tc16.toggle(false);
            }
        });
        setupToolbar();
        setupMenu();

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
    public void onBackPressed() {
        if (mDrawer.isMenuVisible()) {
            mDrawer.closeMenu();
        } else {
            finish();
        }
    }
}
