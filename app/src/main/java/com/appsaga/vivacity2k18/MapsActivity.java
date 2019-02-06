package com.appsaga.vivacity2k18;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sa90.materialarcmenu.ArcMenu;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.android.rides.RideParameters;
import com.uber.sdk.android.rides.RideRequestButton;
import com.uber.sdk.core.auth.Scope;
import com.uber.sdk.rides.client.ServerTokenSession;
import com.uber.sdk.rides.client.SessionConfiguration;

import java.util.Arrays;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    FloatingActionButton fab1;
    FloatingActionButton fab2;
    FloatingActionButton fab3;
    FloatingActionButton fab4;
    FloatingActionButton fab5;

    double longitude;
    double latitude;
    RideRequestButton requestButton;
    SessionConfiguration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fab1=findViewById(R.id.fab1);
        fab2=findViewById(R.id.fab2);
        fab3=findViewById(R.id.fab3);
        fab4=findViewById(R.id.fab4);
        fab5=findViewById(R.id.fab5);

        //LocationManager lm = (LocationManager) getSystemService(MapsActivity.LOCATION_SERVICE);
        /*if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        }
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if(location!=null) {
            longitude = location.getLongitude();
            latitude = location.getLatitude();
        }
        else{
            //Toast.makeText(MapsActivity.this,"Please grant GPS permission",Toast.LENGTH_LONG).show();
            latitude=26.915550;
            longitude=75.816897;
        }*/

        config = new SessionConfiguration.Builder()
                .setClientId("mX-q787yWo5Qz-cVoX4-u_mIG6jcanDJ")
                .setServerToken("IF1yynEJhsAF3ZgfDqWQhBnmJCR9u6q9SoxhVKLU")
                .setEnvironment(SessionConfiguration.Environment.SANDBOX)
                .build();

        UberSdk.initialize(config);

        requestButton = findViewById(R.id.ride);

        RideParameters rideParams = new RideParameters.Builder()
                // Optional product_id from /v1/products endpoint (e.g. UberX). If not provided, most cost-efficient product will be used
                .setProductId("a1111c8c-c720-46c3-8534-2fcdd730040d")
                // Required for price estimates; lat (Double), lng (Double), nickname (String), formatted address (String) of dropoff location
                .setDropoffLocation(
                        26.937963, 75.922669, "LNMIIT", "LNMIIT")
                // Required for pickup estimates; lat (Double), lng (Double), nickname (String), formatted address (String) of pickup location
                .setPickupLocation(26.915424, 75.816838, "Start Point", "Start Point")
                .build();
        // set parameters for the RideRequestButton instance
        requestButton.setRideParameters(rideParams);

        ServerTokenSession session = new ServerTokenSession(config);
        requestButton.setSession(session);

        requestButton.loadRideInformation();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoomLevel = 16.0f;
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        //BitmapDescriptor events = BitmapDescriptorFactory.fromResource(R.drawable.events);
        LatLng LNMIIT = new LatLng(26.936401, 75.923528);
        final Marker lnmiitMarker = mMap.addMarker(new MarkerOptions().position(LNMIIT).title("LNMIIT"));
        lnmiitMarker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LNMIIT, zoomLevel));

        final LatLng OAT = new LatLng(26.934848, 75.923748);
        final Marker OATMarker = mMap.addMarker(new MarkerOptions().position(OAT).title("OAT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(OAT));

        final LatLng Canteen = new LatLng(26.934653, 75.923385);
        final Marker canteenMarker = mMap.addMarker(new MarkerOptions().position(Canteen).title("Canteen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Canteen));

        LatLng SAC = new LatLng(26.933167, 75.923169);
        final Marker SACMarker = mMap.addMarker(new MarkerOptions().position(SAC).title("Social Activity Centre(SAC)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SAC));

        LatLng MessA = new LatLng(26.934762, 75.922815);
        final Marker messAMarker = mMap.addMarker(new MarkerOptions().position(MessA).title("MessA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MessA));

        LatLng MessB = new LatLng(26.935092, 75.925221);
        final Marker messBMarker = mMap.addMarker(new MarkerOptions().position(MessB).title("MessB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MessB));

        LatLng GH = new LatLng(26.935000, 75.922890);
        final Marker GHMarker = mMap.addMarker(new MarkerOptions().position(GH).title("GH Entry"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(GH));

        final LatLng BH1 = new LatLng(26.933896, 75.923057);
        final Marker BH1Marker = mMap.addMarker(new MarkerOptions().position(BH1).title("BH1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BH1));

        LatLng BH2 = new LatLng(26.933875, 75.923228);
        final Marker BH2Marker = mMap.addMarker(new MarkerOptions().position(BH2).title("BH2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BH2));

        LatLng BH3 = new LatLng(26.934662, 75.924264);
        final Marker BH3Marker = mMap.addMarker(new MarkerOptions().position(BH3).title("BH3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BH3));

        LatLng SBI_ATM = new LatLng(26.933959, 75.920655);
        final Marker SBIMarker = mMap.addMarker(new MarkerOptions().position(SBI_ATM).title("SBI ATM"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SBI_ATM));

        LatLng GuestHouse = new LatLng(26.934743, 75.921792);
        final Marker GuestMarker = mMap.addMarker(new MarkerOptions().position(GuestHouse).title("Guest House"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(GuestHouse));

        LatLng Library = new LatLng(26.936025, 75.923101);
        final Marker LibraryMarker = mMap.addMarker(new MarkerOptions().position(Library).title("Library"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Library));

        LatLng CP = new LatLng(26.936277, 75.923304);
        final Marker CPMarker = mMap.addMarker(new MarkerOptions().position(CP).title("Central Plaza(CP)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CP));

        LatLng Acads = new LatLng(26.935960, 75.924120);
        final Marker AcadsMarker = mMap.addMarker(new MarkerOptions().position(Acads).title("Academic Area"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Acads));

        LatLng Hp = new LatLng(26.933350, 75.923346);
        final Marker HpMarker = mMap.addMarker(new MarkerOptions().position(Hp).title("Medical Unit"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Hp));

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnmiitMarker.setVisible(false);
                canteenMarker.setVisible(false);
                BH1Marker.setVisible(false);
                BH2Marker.setVisible(false);
                BH3Marker.setVisible(false);
                GHMarker.setVisible(false);
                messAMarker.setVisible(false);
                messBMarker.setVisible(false);
                OATMarker.setVisible(true);
                SACMarker.setVisible(true);
                SBIMarker.setVisible(false);
                GuestMarker.setVisible(false);
                LibraryMarker.setVisible(false);
                CPMarker.setVisible(true);
                AcadsMarker.setVisible(false);
                HpMarker.setVisible(false);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnmiitMarker.setVisible(false);
                canteenMarker.setVisible(true);
                BH1Marker.setVisible(false);
                BH2Marker.setVisible(false);
                BH3Marker.setVisible(false);
                GHMarker.setVisible(false);
                messAMarker.setVisible(true);
                messBMarker.setVisible(true);
                OATMarker.setVisible(false);
                SACMarker.setVisible(false);
                SBIMarker.setVisible(false);
                GuestMarker.setVisible(false);
                LibraryMarker.setVisible(false);
                CPMarker.setVisible(false);
                AcadsMarker.setVisible(false);
                HpMarker.setVisible(false);
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnmiitMarker.setVisible(false);
                canteenMarker.setVisible(false);
                BH1Marker.setVisible(true);
                BH2Marker.setVisible(true);
                BH3Marker.setVisible(true);
                GHMarker.setVisible(true);
                messAMarker.setVisible(false);
                messBMarker.setVisible(false);
                OATMarker.setVisible(false);
                SACMarker.setVisible(false);
                SBIMarker.setVisible(false);
                GuestMarker.setVisible(false);
                LibraryMarker.setVisible(false);
                CPMarker.setVisible(false);
                AcadsMarker.setVisible(false);
                HpMarker.setVisible(false);
            }
        });

        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnmiitMarker.setVisible(true);
                canteenMarker.setVisible(false);
                BH1Marker.setVisible(false);
                BH2Marker.setVisible(false);
                BH3Marker.setVisible(false);
                GHMarker.setVisible(false);
                messAMarker.setVisible(false);
                messBMarker.setVisible(false);
                OATMarker.setVisible(false);
                SACMarker.setVisible(false);
                SBIMarker.setVisible(false);
                GuestMarker.setVisible(true);
                LibraryMarker.setVisible(true);
                CPMarker.setVisible(false);
                AcadsMarker.setVisible(true);
                HpMarker.setVisible(true);
            }
        });

        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnmiitMarker.setVisible(false);
                canteenMarker.setVisible(false);
                BH1Marker.setVisible(false);
                BH2Marker.setVisible(false);
                BH3Marker.setVisible(false);
                GHMarker.setVisible(false);
                messAMarker.setVisible(false);
                messBMarker.setVisible(false);
                OATMarker.setVisible(false);
                SACMarker.setVisible(false);
                SBIMarker.setVisible(true);
                GuestMarker.setVisible(false);
                LibraryMarker.setVisible(false);
                CPMarker.setVisible(false);
                AcadsMarker.setVisible(false);
                HpMarker.setVisible(false);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
