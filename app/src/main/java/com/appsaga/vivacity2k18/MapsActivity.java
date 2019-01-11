package com.appsaga.vivacity2k18;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        LatLng LNMIIT = new LatLng(26.936401, 75.923528);
        mMap.addMarker(new MarkerOptions().position(LNMIIT).title("LNMIIT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LNMIIT, zoomLevel));

        LatLng OAT = new LatLng(26.934848, 75.923748);
        mMap.addMarker(new MarkerOptions().position(OAT).title("OAT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(OAT));

        LatLng Canteen = new LatLng(26.934653, 75.923385);
        mMap.addMarker(new MarkerOptions().position(Canteen).title("Canteen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Canteen));

        LatLng SAC = new LatLng(26.933167, 75.923169);
        mMap.addMarker(new MarkerOptions().position(SAC).title("Social Activity Centre(SAC)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SAC));

        LatLng MessA = new LatLng(26.934762, 75.922815);
        mMap.addMarker(new MarkerOptions().position(MessA).title("MessA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MessA));

        LatLng MessB = new LatLng(26.935092, 75.925221);
        mMap.addMarker(new MarkerOptions().position(MessB).title("MessB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MessB));

        LatLng GH = new LatLng(26.935000, 75.922890);
        mMap.addMarker(new MarkerOptions().position(GH).title("GH Entry"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(GH));

        LatLng BH1 = new LatLng(26.933896, 75.923057);
        mMap.addMarker(new MarkerOptions().position(BH1).title("BH1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BH1));

        LatLng BH2 = new LatLng(26.933875, 75.923228);
        mMap.addMarker(new MarkerOptions().position(BH2).title("BH2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BH2));

        LatLng BH3 = new LatLng(26.934662, 75.924264);
        mMap.addMarker(new MarkerOptions().position(BH3).title("BH3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BH3));
    }
}
