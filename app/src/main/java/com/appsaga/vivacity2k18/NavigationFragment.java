package com.appsaga.vivacity2k18;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class NavigationFragment extends Fragment {
    //private ImageView ivMenuUserProfilePhoto;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container,
                false);
        //ivMenuUserProfilePhoto = (ImageView) view.findViewById(R.id.ivMenuUserProfilePhoto);
        NavigationView vNavigation = (NavigationView) view.findViewById(R.id.vNavigation);
        vNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.events:
                        startActivity(new Intent(getContext(), Events.class));
                        break;
                    case R.id.bus:
                        String url = "https://www.lnmiit.ac.in/uploaded_Files/Bus_time_Table_15-10-2018.pdf";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case R.id.funEvents:
                        startActivity(new Intent(getContext(), FunEvents.class));
                        break;
                    case R.id.pronite:
                        startActivity(new Intent(getContext(), Pronites.class));
                        break;
                    case R.id.onGoing:
                        startActivity(new Intent(getContext(), OnGoing.class));

                        break;
                    case R.id.map:
                        startActivity(new Intent(getContext(), MapsActivity.class));
                        break;
                    case R.id.team:
                        startActivity(new Intent(getContext(), Team.class));
                        break;
                    case R.id.sponsor:
                        startActivity(new Intent(getContext(), Sponsors.class));
                        break;
                    case R.id.contact:
                        startActivity(new Intent(getContext(), ContactUs.class));
                        break;
                    case R.id.developer:
                        startActivity(new Intent(getContext(), Developer.class));
                        break;

                }
                return false;
            }
        });
        // setupHeader();
        return view;
    }
}
