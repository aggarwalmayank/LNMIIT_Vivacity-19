package com.appsaga.vivacity2k18;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.appsaga.vivacity2k18.AllEventDetails;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.annotation.Nullable;

public class AllEvent_Fragment extends Fragment {
    private Animation animation;
    Handler handler = new Handler();
    public static final String KEY_Link = "Link";

    private  String gamerules;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference dbref = db.collection("Events").document("Gaming");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //GlitchEffect.showGlitch((Activity) this.getContext());

        View rootView = inflater.inflate(R.layout.fragment_all_event_, container, false);

        final ArrayList<AllEventDetails> all = new ArrayList<>();
        all.add(new AllEventDetails(getResources().getString(R.string.dance), R.drawable.dance));   //0
        all.add(new AllEventDetails(getResources().getString(R.string.fashion), R.drawable.fashion));                           //1
        all.add(new AllEventDetails(getResources().getString(R.string.art), R.drawable.art));                                   //2
        all.add(new AllEventDetails(getResources().getString(R.string.music), R.drawable.music));                                           //3
        all.add(new AllEventDetails(getResources().getString(R.string.drama), R.drawable.drama));            //4
        all.add(new AllEventDetails(getResources().getString(R.string.nukkad), R.drawable.nukkad));             //5
        all.add(new AllEventDetails(getResources().getString(R.string.imagi), R.drawable.camera));                                          //6
        all.add(new AllEventDetails(getResources().getString(R.string.ifp), R.drawable.film));                                          //8
        all.add(new AllEventDetails(getResources().getString(R.string.openmic), R.drawable.openmic));                                   //7
        all.add(new AllEventDetails(getResources().getString(R.string.gaming), R.drawable.gaming));                                                       //9
        all.add(new AllEventDetails(getResources().getString(R.string.sahoyag), R.drawable.sankalp));                                           //10
        all.add(new AllEventDetails(getResources().getString(R.string.ipl), R.drawable.ipl));
        all.add(new AllEventDetails(getResources().getString(R.string.quiz), R.drawable.finalquiz));//11

        dbref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    gamerules = documentSnapshot.getString(KEY_Link);
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


        AllEventAdapter eventsAdapter = new AllEventAdapter(getActivity(), all);

        ListView list = rootView.findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.DanceEvents.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        //startActivity(new Intent(getContext(), DanceEvents.class));
                        break;
                    case 1:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.FashionEvents.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        //startActivity(new Intent(getContext(), FashionEvents.class));
                        break;
                    case 2:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.ArtEvents.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        //startActivity(new Intent(getContext(), ArtEvents.class));
                        break;
                    case 3:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.MusicEvents.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        //startActivity(new Intent(getContext(), MusicEvents.class));
                        break;
                    case 4:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.DramaEvents.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        //startActivity(new Intent(getContext(), DramaEvents.class));
                        break;
                    case 5:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.NukkadNatak.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        //startActivity(new Intent(getContext(), DramaEvents.class));
                        break;
                    case 6:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.PhotographyEvents.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        //startActivity(new Intent(getContext(), FlashFolks.class));
                        break;
                    case 7:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.Ifp.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        //startActivity(new Intent(getContext(), openmic.class));
                        break;
                    case 8:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.openmic.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);

                        // startActivity(new Intent(getContext(), Ifp.class));
                        break;
                    case 9:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                popup();
                                //finish();
                            }
                        }, 500);
                        break;
                    case 10:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.Social.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        break;
                    case 11:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.Ipl.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        break;
                    case 12:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                        view.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getContext(), com.appsaga.vivacity2k18.Quiz.class);
                                startActivity(intent);
                                //finish();
                            }
                        }, 500);
                        break;
                }
            }
        });


        list.setAdapter(eventsAdapter);
        return rootView;
    }
    public void onStart() {
        super.onStart();

            super.onStart();
            dbref.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    if(e!=null){
                        Toast.makeText(getContext(), "error while loading", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(documentSnapshot.exists()){
                        gamerules=documentSnapshot.getString(KEY_Link);
                    }
                }
            });



    }
    public void popup() {
        if (gamerules.equals("0")) {
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
        }
        else{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(gamerules));
            startActivity(i);
        }

    }
}
