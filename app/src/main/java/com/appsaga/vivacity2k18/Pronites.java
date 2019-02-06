package com.appsaga.vivacity2k18;

import android.annotation.TargetApi;
import android.app.Activity;
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
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.squareup.picasso.Picasso;

import javax.annotation.Nullable;

public class Pronites extends AppCompatActivity {

    //private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    FlowingDrawer mDrawer;

    public static final String KEY_URL1 = "URL1";
    public static final String KEY_URL2 = "URL2";
    public static final String KEY_URL3 = "URL3";
    public static final String KEY_URL4 = "URL4";

    public static final String KEY_URL5 = "URL5";
    public static final String KEY_URL6 = "URL6";
    public static final String KEY_URL7 = "URL7";
    public static final String KEY_URL8 = "URL8";
    public static final String KEY_URL9 = "URL9";

    private ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference dbref = db.collection("URLS").document("PRONITES");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronites);

        i1 = findViewById(R.id.p1);
        i2 = findViewById(R.id.p2);
        i3 = findViewById(R.id.p3);
        i4 = findViewById(R.id.p4);

        i5 = findViewById(R.id.p5);
        i6 = findViewById(R.id.p6);
        i7 = findViewById(R.id.p7);
        i8 = findViewById(R.id.p8);
        i9 = findViewById(R.id.p9);


        setupToolbar();
        setupMenu();

        dbref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String u1 = documentSnapshot.getString(KEY_URL1);
                    String u2 = documentSnapshot.getString(KEY_URL2);
                    String u3 = documentSnapshot.getString(KEY_URL3);
                    String u4 = documentSnapshot.getString(KEY_URL4);
                    String u5 = documentSnapshot.getString(KEY_URL5);
                    String u6 = documentSnapshot.getString(KEY_URL6);
                    String u7 = documentSnapshot.getString(KEY_URL7);
                    String u8 = documentSnapshot.getString(KEY_URL8);
                    String u9 = documentSnapshot.getString(KEY_URL9);
                    if (u1.equals("1")) {
                        i1.setVisibility(View.VISIBLE);
                        i1.setImageResource(R.drawable.yettoberevealed);

                    } else if (u1.equals("0")) {
                        i1.setVisibility(View.INVISIBLE);
                    } else {
                        i1.setVisibility(View.VISIBLE);
                        Picasso.get().load(u1).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i1);
                    }


                    if (u2.equals("1")) {
                        i2.setVisibility(View.VISIBLE);
                        i2.setImageResource(R.drawable.yettoberevealed);

                    } else if (u2.equals("0")) {
                        i2.setVisibility(View.INVISIBLE);
                    } else {
                        i2.setVisibility(View.VISIBLE);
                        Picasso.get().load(u2).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i2);
                    }


                    if (u3.equals("1")) {
                        i3.setVisibility(View.VISIBLE);
                        i3.setImageResource(R.drawable.yettoberevealed);

                    } else if (u3.equals("0")) {
                        i3.setVisibility(View.INVISIBLE);
                    } else {
                        i3.setVisibility(View.VISIBLE);
                        Picasso.get().load(u3).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i3);
                    }


                    if (u4.equals("1")) {
                        i4.setVisibility(View.VISIBLE);
                        i4.setImageResource(R.drawable.yettoberevealed);
                    } else if (u4.equals("0")) {
                        i4.setVisibility(View.INVISIBLE);
                    } else {
                        i4.setVisibility(View.VISIBLE);
                        Picasso.get().load(u4).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i4);
                    }
                    if (u5.equals("1")) {
                        i5.setVisibility(View.VISIBLE);
                        i5.setImageResource(R.drawable.yettoberevealed);
                    } else if (u5.equals("0")) {
                        i5.setVisibility(View.INVISIBLE);
                    } else {
                        i5.setVisibility(View.VISIBLE);
                        Picasso.get().load(u5).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i5);
                    }
                    if (u6.equals("1")) {
                        i6.setVisibility(View.VISIBLE);
                        i6.setImageResource(R.drawable.yettoberevealed);
                    } else if (u6.equals("0")) {
                        i6.setVisibility(View.INVISIBLE);
                    } else {
                        i6.setVisibility(View.VISIBLE);
                        Picasso.get().load(u4).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i6);
                    }
                    if (u7.equals("1")) {
                        i7.setVisibility(View.VISIBLE);
                        i7.setImageResource(R.drawable.yettoberevealed);
                    } else if (u7.equals("0")) {
                        i7.setVisibility(View.INVISIBLE);
                    } else {
                        i7.setVisibility(View.VISIBLE);
                        Picasso.get().load(u7).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i7);
                    }
                    if (u8.equals("1")) {
                        i8.setVisibility(View.VISIBLE);
                        i8.setImageResource(R.drawable.yettoberevealed);
                    } else if (u8.equals("0")) {
                        i8.setVisibility(View.INVISIBLE);
                    } else {
                        i8.setVisibility(View.VISIBLE);
                        Picasso.get().load(u8).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i8);
                    }
                    if (u9.equals("1")) {
                        i9.setVisibility(View.VISIBLE);
                        i9.setImageResource(R.drawable.yettoberevealed);
                    } else if (u9.equals("0")) {
                        i9.setVisibility(View.INVISIBLE);
                    } else {

                        i9.setVisibility(View.VISIBLE);
                        Picasso.get().load(u9).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i9);
                    }
                } else {
                    Toast.makeText(Pronites.this, "doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Pronites.this, "Please Enable Mobile Data", Toast.LENGTH_SHORT).show();
            }
        });
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

    protected void onStart() {
        super.onStart();
        dbref.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(Pronites.this, "error while loading", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (documentSnapshot.exists()) {
                    String u1 = documentSnapshot.getString(KEY_URL1);
                    String u2 = documentSnapshot.getString(KEY_URL2);
                    String u3 = documentSnapshot.getString(KEY_URL3);
                    String u4 = documentSnapshot.getString(KEY_URL4);
                    String u5 = documentSnapshot.getString(KEY_URL5);
                    String u6 = documentSnapshot.getString(KEY_URL6);
                    String u7 = documentSnapshot.getString(KEY_URL7);
                    String u8 = documentSnapshot.getString(KEY_URL8);
                    String u9 = documentSnapshot.getString(KEY_URL9);
                    if (u1.equals("1")) {
                        i1.setVisibility(View.VISIBLE);
                        i1.setImageResource(R.drawable.yettoberevealed);

                    } else if (u1.equals("0")) {
                        i1.setVisibility(View.INVISIBLE);
                    } else {
                        i1.setVisibility(View.VISIBLE);
                        Picasso.get().load(u1).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i1);
                    }


                    if (u2.equals("1")) {
                        i2.setVisibility(View.VISIBLE);
                        i2.setImageResource(R.drawable.yettoberevealed);

                    } else if (u2.equals("0")) {
                        i2.setVisibility(View.INVISIBLE);
                    } else {
                        i2.setVisibility(View.VISIBLE);
                        Picasso.get().load(u2).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i2);
                    }


                    if (u3.equals("1")) {
                        i3.setVisibility(View.VISIBLE);
                        i3.setImageResource(R.drawable.yettoberevealed);

                    } else if (u3.equals("0")) {
                        i3.setVisibility(View.INVISIBLE);
                    } else {
                        i3.setVisibility(View.VISIBLE);
                        Picasso.get().load(u3).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i3);
                    }


                    if (u4.equals("1")) {
                        i4.setVisibility(View.VISIBLE);
                        i4.setImageResource(R.drawable.yettoberevealed);
                    } else if (u4.equals("0")) {
                        i4.setVisibility(View.INVISIBLE);
                    } else {
                        i4.setVisibility(View.VISIBLE);
                        Picasso.get().load(u4).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i4);
                    }
                    if (u5.equals("1")) {
                        i5.setVisibility(View.VISIBLE);
                        i5.setImageResource(R.drawable.yettoberevealed);
                    } else if (u5.equals("0")) {
                        i5.setVisibility(View.INVISIBLE);
                    } else {
                        i5.setVisibility(View.VISIBLE);
                        Picasso.get().load(u5).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i5);
                    }
                    if (u6.equals("1")) {
                        i6.setVisibility(View.VISIBLE);
                        i6.setImageResource(R.drawable.yettoberevealed);
                    } else if (u6.equals("0")) {
                        i6.setVisibility(View.INVISIBLE);
                    } else {
                        i6.setVisibility(View.VISIBLE);
                        Picasso.get().load(u4).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i6);
                    }
                    if (u7.equals("1")) {
                        i7.setVisibility(View.VISIBLE);
                        i7.setImageResource(R.drawable.yettoberevealed);
                    } else if (u7.equals("0")) {
                        i7.setVisibility(View.INVISIBLE);
                    } else {
                        i7.setVisibility(View.VISIBLE);
                        Picasso.get().load(u7).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i7);
                    }
                    if (u8.equals("1")) {
                        i8.setVisibility(View.VISIBLE);
                        i8.setImageResource(R.drawable.yettoberevealed);
                    } else if (u8.equals("0")) {
                        i8.setVisibility(View.INVISIBLE);
                    } else {
                        i8.setVisibility(View.VISIBLE);
                        Picasso.get().load(u8).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i8);
                    }
                    if (u9.equals("1")) {
                        i9.setVisibility(View.VISIBLE);
                        i9.setImageResource(R.drawable.yettoberevealed);
                    } else if (u9.equals("0")) {
                        i9.setVisibility(View.INVISIBLE);
                    } else {

                        i9.setVisibility(View.VISIBLE);
                        Picasso.get().load(u9).fit().centerCrop()
                                .placeholder(R.drawable.vv)
                                .into(i9);
                    }

                }
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
}
