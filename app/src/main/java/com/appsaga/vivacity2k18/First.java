package com.appsaga.vivacity2k18;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.android.rides.RideParameters;
import com.uber.sdk.android.rides.RideRequestButton;
import com.uber.sdk.rides.client.SessionConfiguration;

import javax.annotation.Nullable;

public class First extends AppCompatActivity {

    TextView Event;
    TextView Gallery;
    ImageView about;
    TextView contactUs;
    TextView map;
    TextView team;
    TextView sponsors;
    TextView onGoing;
    TextView funEvents;
    TextView pronites;
    private  String bustt;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference dbref = db.collection("URLS").document("BUS");
    public static final String KEY_TT = "link";
    FlowingDrawer mDrawer;
    private CircleMenu circleMenu;
    int DELAY = 1000;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    double longitude;
    double latitude;
    RideRequestButton requestButton;
    SessionConfiguration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        setupToolbar();
        setupMenu();
        ImageView aboutus = (ImageView) findViewById(R.id.about);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First.this, AboutUs.class));
            }
        });

                /*Event = findViewById(R.id.Events);

        Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEvent();
            }
        });


        about = findViewById(R.id.AboutUs);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAbout();
            }
        });

        contactUs = findViewById(R.id.ContactUs);

        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToContactUs();
            }
        });

        map = findViewById(R.id.Map);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMap();
            }
        });

        team = findViewById(R.id.team);

        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTeam();
            }
        });

        sponsors = findViewById(R.id.sponsor);

        sponsors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSponsor();
            }
        });

        onGoing = findViewById(R.id.ongoing);

        onGoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToOnGoing();
            }
        });

        funEvents = findViewById(R.id.fun_events);

        funEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToFunEvents();
            }
        });

        pronites = findViewById(R.id.pronites);

        pronites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToPronites();
            }
        });

        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.map_white);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                drawerLayout.closeDrawers();

                switch (id) {
                    case R.id.events:
                        goToEvent();
                        break;
                    case R.id.map:
                        goToMap();
                        break;
                    case R.id.gallery:
                        goToGallery();
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

        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#ffffff"), R.drawable.mainmenu_circle, R.drawable.cancel_circle);
        circleMenu.addSubMenu(Color.parseColor("#124f12"), R.drawable.event_circle)
                .addSubMenu(Color.parseColor("#710000"), R.drawable.bus_circle)
                .addSubMenu(Color.parseColor("#0f0f4d"), R.drawable.pronite_circle)
                .addSubMenu(Color.parseColor("#440b0b"), R.drawable.contact_circle)
                .addSubMenu(Color.parseColor("#44023f"), R.drawable.team_circle)
                .addSubMenu(Color.parseColor("#002e56"), R.drawable.dancers_circle);

        final Handler handler = new Handler();
        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

                                                 @Override
                                                 public void onMenuSelected(int index) {
                                                     switch (index) {
                                                         case 0:
                                                             handler.postDelayed(new Runnable() {
                                                                 @Override
                                                                 public void run() {

                                                                     cmenu(0);
                                                                 }
                                                             }, DELAY);
                                                             break;
                                                         case 1:
                                                             handler.postDelayed(new Runnable() {
                                                                 @Override
                                                                 public void run() {

                                                                     cmenu(1);
                                                                 }
                                                             }, DELAY);
                                                             break;
                                                         case 2:
                                                             handler.postDelayed(new Runnable() {
                                                                 @Override
                                                                 public void run() {

                                                                     cmenu(2);
                                                                 }
                                                             }, DELAY);
                                                             break;
                                                         case 3:
                                                             handler.postDelayed(new Runnable() {
                                                                 @Override
                                                                 public void run() {

                                                                     cmenu(3);
                                                                 }
                                                             }, DELAY);
                                                             break;
                                                         case 4:
                                                             handler.postDelayed(new Runnable() {
                                                                 @Override
                                                                 public void run() {

                                                                     cmenu(4);
                                                                 }
                                                             }, DELAY);
                                                             break;
                                                         case 5:
                                                             handler.postDelayed(new Runnable() {
                                                                 @Override
                                                                 public void run() {

                                                                     cmenu(5);
                                                                 }
                                                             }, DELAY);
                                                         case 6:
                                                             handler.postDelayed(new Runnable() {
                                                                 @Override
                                                                 public void run() {

                                                                     cmenu(6);
                                                                 }
                                                             }, DELAY);
                                                     }
                                                 }
                                             }


        );

        dbref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    bustt= documentSnapshot.getString(KEY_TT);
                } else {
                    Toast.makeText(First.this, "doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(First.this, "Please Enable Mobile Data", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void search(View view){

        RideParameters rideParams = new RideParameters.Builder()
                // Optional product_id from /v1/products endpoint (e.g. UberX). If not provided, most cost-efficient product will be used
                .setProductId("a1111c8c-c720-46c3-8534-2fcdd730040d")
                // Required for price estimates; lat (Double), lng (Double), nickname (String), formatted address (String) of dropoff location
                .setDropoffLocation(
                        26.937963, 75.922669, "LNMIIT", "LNMIIT")
                // Required for pickup estimates; lat (Double), lng (Double), nickname (String), formatted address (String) of pickup location
                .setPickupLocation(latitude, longitude, "Start Point", "Start Point")
                .build();
        // set parameters for the RideRequestButton instance
        //requestButton.setRideParameters(rideParams);

        //ServerTokenSession session = new ServerTokenSession(config);
        //requestButton.setSession(session);

        //requestButton.loadRideInformation();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
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
    public void onBackPressed() {
        if (mDrawer.isMenuVisible()) {
            mDrawer.closeMenu();
        }
        else if(circleMenu.isOpened()){
            circleMenu.closeMenu();
        }
        else {
            finish();
        }
    }

    public void cmenu(int index) {
        if (index == 0)
            startActivity(new Intent(this, Events.class));
        else if (index == 1) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(bustt));
            startActivity(i);
        } else if (index == 2)
            startActivity(new Intent(this, Pronites.class));
        else if (index == 3)
            startActivity(new Intent(this, ContactUs.class));
        else if (index == 4)
            startActivity(new Intent(this, AllTeam.class));

        else if (index == 5)
            startActivity(new Intent(this, FunEvents.class));
    }
    public void insta(View v){
        String socialNetwork = "https://www.instagram.com/vivacity_lnmiit/";
        startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse(socialNetwork)), "Open with:"));
    }

    public void fb(View v){
        String socialNetwork = "https://www.facebook.com/Vivacity.LNMIIT/";
        startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse(socialNetwork)), "Open with:"));
    }

    public void yt(View v){
        String socialNetwork = "https://bit.ly/2Dbfpsl";
        startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse(socialNetwork)), "Open with:"));
    }
    protected void onStart() {
        super.onStart();

        super.onStart();
        dbref.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if(e!=null){
                    Toast.makeText(First.this, "error while loading", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(documentSnapshot.exists()){
                    bustt=documentSnapshot.getString(KEY_TT);
                }
            }
        });



    }
}
