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


public class FlashFolks extends AppCompatActivity {

    public static final String KEY_TIME="Time";
   // public static final String KEY_VENUE="Venue";
   // public static final String KEY_DAY="Day";

    private TextView timeView;
   // private TextView venueView;
    //private TextView dayView;

    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private DocumentReference dbref=db.collection("Events").document("Flash Folks");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_folks);
        ActionBar actionbar=getSupportActionBar();
        actionbar.setTitle("Photography");

        timeView=findViewById(R.id.flashfolkstime);
      //  venueView=findViewById(R.id.flashfolksvenue);
       // dayView=findViewById(R.id.flashfolksday);
        TextView reg=(TextView)findViewById(R.id.regflashfolks);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.vivacity.lnmiit.ac.in/forms/regphoto.html";
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
         //           String day=documentSnapshot.getString(KEY_DAY);
           //         String venue=documentSnapshot.getString(KEY_VENUE);

             //       venueView.setText("Venue: "+venue);
               //     dayView.setText("Day "+day);
                    timeView.setText("ONLINE EVENT");
                }
                else{
                    Toast.makeText(FlashFolks.this, "doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FlashFolks.this, "Please Enable Mobile Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void onStart() {
        super.onStart();
        dbref.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if(e!=null){
                    Toast.makeText(FlashFolks.this, "error while loading", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(documentSnapshot.exists()){
                    String time=documentSnapshot.getString(KEY_TIME);
                    //String day=documentSnapshot.getString(KEY_DAY);
                    //String venue=documentSnapshot.getString(KEY_VENUE);

                    //venueView.setText("Venue: "+venue);
                    //dayView.setText("Day "+day);
                    timeView.setText("ONLINE EVENT");
                }
            }
        });

    }
}
