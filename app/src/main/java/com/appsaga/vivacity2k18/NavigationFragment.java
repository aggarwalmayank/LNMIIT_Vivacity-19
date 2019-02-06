package com.appsaga.vivacity2k18;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class NavigationFragment extends Fragment {
    //private ImageView ivMenuUserProfilePhoto;
    private String eventsch;

    public static final String KEY_Link = "link";
    private  String bustt;

    public static final String KEY_TT = "link";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference dbbus = db.collection("URLS").document("BUS");
    private DocumentReference dbref = db.collection("Event Sch").document("Sch");
    private DocumentReference dbsponsor = db.collection("URLS").document("SPONSORS");
String urltoload;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container,
                false);

        dbref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    eventsch = documentSnapshot.getString(KEY_Link);
                } else {
                    Toast.makeText(getContext(), "doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Please Enable Mobile Data", Toast.LENGTH_SHORT).show();
            }
        });
        dbsponsor.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    urltoload = documentSnapshot.getString("URL");
                } else {
                    Toast.makeText(getContext(), "doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Please Enable Mobile Data", Toast.LENGTH_SHORT).show();
            }
        });


        dbbus.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    bustt = documentSnapshot.getString(KEY_TT);
                } else {
                    Toast.makeText(getContext(), "doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Please Enable Mobile Data", Toast.LENGTH_SHORT).show();
            }
        });

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

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(bustt));
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
                        startActivity(new Intent(getContext(), AllTeam.class));
                        break;
                    case R.id.sponsor:
                        if(urltoload.equals("0"))
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                                    .setMessage("Will be updated soon...\nStay Vivacious...")
                                    .setCancelable(false)
                                    .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    });
                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                        else
                        startActivity(new Intent(getContext(), Sponsors.class));
                        break;
                    case R.id.event_schedule:
                        openschedule();
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

    public void onStart() {
        super.onStart();

        super.onStart();
        dbref.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Toast.makeText(getContext(), "error while loading", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (documentSnapshot.exists()) {
                            eventsch = documentSnapshot.getString(KEY_Link);
                        }
            }
        });
        dbsponsor.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(getContext(), "error while loading", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (documentSnapshot.exists()) {
           urltoload= documentSnapshot.getString("URL");
                }
            }
        });
        dbbus.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if(e!=null){
                    Toast.makeText(getContext(), "error while loading", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(documentSnapshot.exists()){
                    bustt=documentSnapshot.getString(KEY_TT);
                }
            }
        });


    }

    public void openschedule() {
        if (eventsch.equals("0")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                    .setMessage("Will be updated soon...")
                    .setCancelable(false)
                    .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(eventsch));
            startActivity(i);
        }
    }
}
