package com.appsaga.vivacity2k18;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import javax.annotation.Nullable;


public class RapBattle extends AppCompatActivity {

    public static final String KEY_TIME="Time";
    public static final String KEY_VENUE="Venue";
    public static final String KEY_DAY="Day";

    private TextView timeView;
    private TextView venueView;
    private TextView dayView;

    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private DocumentReference dbref=db.collection("Events").document("Rap Battle");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rap_battle);
        ActionBar actionbar=getSupportActionBar();

        timeView=findViewById(R.id.raptime);
        venueView=findViewById(R.id.rapvenue);
        dayView=findViewById(R.id.rapday);
        TextView reg=(TextView)findViewById(R.id.regflashfolks);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.vivacity.lnmiit.ac.in/forms/regmusic.html";
                Intent website = new Intent(Intent.ACTION_VIEW);
                website.setData(Uri.parse(url));
                startActivity(website);
            }
        });


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
                    Toast.makeText(RapBattle.this, "doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RapBattle.this, "Please Enable Mobile Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void onStart() {
        super.onStart();
        dbref.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if(e!=null){
                    Toast.makeText(RapBattle.this, "error while loading", Toast.LENGTH_SHORT).show();
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
