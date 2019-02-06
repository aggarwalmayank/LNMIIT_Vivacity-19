package com.appsaga.vivacity2k18;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OnGoing extends AppCompatActivity {
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference dbref=db.collection("Events");
    private EventAdapter adapter;

    private long time;
    private String date;
    private String curdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_going);
        ActionBar actionbar=getSupportActionBar();
        actionbar.setTitle("OnGoing");


        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        date = df.format(Calendar.getInstance().getTime());

        DateFormat tf = new SimpleDateFormat("hh:mm a");
        time = Calendar.getInstance().getTimeInMillis();

        curdate=date.substring(0,2);
        if(curdate.equals("1"))
            curdate="1";
        else if(curdate.equals("2"))
            curdate="2";
        else
            curdate="3";
        setupRecyclerView();
    }

    private  void setupRecyclerView() {
        if (curdate.equals("1")) {
            Query query = dbref.whereLessThanOrEqualTo("unix", time).whereGreaterThan("unix",time-900000).whereEqualTo("Day",curdate).orderBy("unix",Query.Direction.ASCENDING);

            FirestoreRecyclerOptions<EventDetail> options = new FirestoreRecyclerOptions.Builder<EventDetail>().setQuery(query, EventDetail.class)
                    .build();

            adapter = new EventAdapter(options);
            RecyclerView recyclerView = findViewById(R.id.recycler_view_ongoing);
            recyclerView.setHasFixedSize(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
        else if(curdate.equals("2")){
            Query query = dbref.whereLessThanOrEqualTo("unix", time).whereGreaterThan("unix",time-900000).whereEqualTo("Day",curdate).orderBy("unix",Query.Direction.ASCENDING);

            FirestoreRecyclerOptions<EventDetail> options = new FirestoreRecyclerOptions.Builder<EventDetail>().setQuery(query, EventDetail.class)
                    .build();

            adapter = new EventAdapter(options);
            RecyclerView recyclerView = findViewById(R.id.recycler_view_ongoing);
            recyclerView.setHasFixedSize(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);


        }
        else{
            Query query = dbref.whereLessThanOrEqualTo("unix", time).whereGreaterThan("unix",time-900000).whereEqualTo("Day",curdate).orderBy("unix",Query.Direction.ASCENDING);
            FirestoreRecyclerOptions<EventDetail> options = new FirestoreRecyclerOptions.Builder<EventDetail>().setQuery(query, EventDetail.class)
                    .build();

            adapter = new EventAdapter(options);
            RecyclerView recyclerView = findViewById(R.id.recycler_view_ongoing);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);

        }

    }


    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
