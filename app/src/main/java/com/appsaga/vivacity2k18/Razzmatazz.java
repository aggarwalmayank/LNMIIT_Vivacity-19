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


public class Razzmatazz extends AppCompatActivity {

    public static final String KEY_TIME="Time";
    public static final String KEY_VENUE="Venue";
    public static final String KEY_DAY="Day";

    private TextView timeView;
    private TextView venueView;
    private TextView dayView;

    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private DocumentReference dbref=db.collection("Events").document("Razmatazz");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razzmatazz);
        ActionBar actionbar=getSupportActionBar();
        actionbar.setTitle("Razzmatazz");

        timeView=findViewById(R.id.razztime);
        venueView=findViewById(R.id.razzvenue);
        dayView=findViewById(R.id.razzday);


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
                    Toast.makeText(Razzmatazz.this, "doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Razzmatazz.this, "Please Enable Mobile Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void onStart() {
        super.onStart();
        dbref.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if(e!=null){
                    Toast.makeText(Razzmatazz.this, "error while loading", Toast.LENGTH_SHORT).show();
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
    public void contact1(View v){
        String phone = "+917006638382";
        Intent prabhat = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(prabhat);
    }

    public void contact2(View v){
        String phone = "+917006638382";
        Intent prabhat = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(prabhat);
    }
}
