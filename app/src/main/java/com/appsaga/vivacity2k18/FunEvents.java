package com.appsaga.vivacity2k18;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
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

import javax.annotation.Nullable;

public class FunEvents extends AppCompatActivity {

    //DrawerLayout drawerLayout;
    //private ActionBarDrawerToggle actionBarDrawerToggle;
    FlowingDrawer mDrawer;

    public static final String KEY_TIME="Time";
    public static final String KEY_VENUE="Venue";
    public static final String KEY_DAY="Day";

    private TextView timeView;
    private TextView venueView;
    private TextView dayView;

    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private DocumentReference dbref=db.collection("Events").document("Dologue");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_events);

        setupToolbar();
        setupMenu();

        timeView=findViewById(R.id.dtime);
        venueView=findViewById(R.id.dvenue);
        dayView=findViewById(R.id.dday);
        dbref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    String time=documentSnapshot.getString(KEY_TIME);
                    String day=documentSnapshot.getString(KEY_DAY);
                    String venue=documentSnapshot.getString(KEY_VENUE);

                    venueView.setText("Venue: "+venue);
                    dayView.setText("Day "+day);
                    timeView.setText("Time: "+time);
                }
                else{
                    Toast.makeText(FunEvents.this, "doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FunEvents.this, "Please Enable Mobile Data", Toast.LENGTH_SHORT).show();
            }
        });

      /*  drawerLayout=findViewById(R.id.drawer3);
        actionBarDrawerToggle=new ActionBarDrawerToggle(Events.this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id= menuItem.getItemId();

                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                drawerLayout.closeDrawers();

                switch(id)
                {
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

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }


    void goToContactUs() {

        Intent intent = new Intent(Events.this, com.appsaga.vivacity2k18.ContactUs.class);
        startActivity(intent);
        finish();
    }

    void goToMap() {

        Intent intent = new Intent(Events.this, com.appsaga.vivacity2k18.MapsActivity.class);
        startActivity(intent);
        finish();
    }

    void  goToTeam(){

        Intent intent = new Intent(Events.this,com.appsaga.vivacity2k18.Team.class);
        startActivity(intent);
        finish();
    }

    void goToSponsor(){

        Intent intent = new Intent(Events.this,com.appsaga.vivacity2k18.Sponsors.class);
        startActivity(intent);
        finish();
    }

    void goToOnGoing(){

        Intent intent = new Intent(Events.this,com.appsaga.vivacity2k18.OnGoing.class);
        startActivity(intent);
        finish();
    }

    void goToFunEvents(){

        Intent intent = new Intent(Events.this,com.appsaga.vivacity2k18.FunEvents.class);
        startActivity(intent);
        finish();
    }

    void goToPronites(){

        Intent intent = new Intent(Events.this,com.appsaga.vivacity2k18.Pronites.class);
        startActivity(intent);
        finish();
    }

    void  goToDeveloper(){

        Intent intent = new Intent(Events.this,com.appsaga.vivacity2k18.Developer.class);
        startActivity(intent);
        finish();
    }*/

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
    protected void onStart() {
        super.onStart();
        dbref.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if(e!=null){
                    Toast.makeText(FunEvents.this, "error while loading", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(documentSnapshot.exists()){
                    String time=documentSnapshot.getString(KEY_TIME);
                    String day=documentSnapshot.getString(KEY_DAY);
                    String venue=documentSnapshot.getString(KEY_VENUE);

                    venueView.setText("Venue: "+venue);
                    dayView.setText("Day "+day);
                    timeView.setText("Time: "+time);
                }
            }
        });

    }
}
