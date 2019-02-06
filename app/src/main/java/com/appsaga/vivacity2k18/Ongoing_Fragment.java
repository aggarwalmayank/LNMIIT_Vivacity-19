package com.appsaga.vivacity2k18;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ongoing_Fragment extends Fragment {
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference dbref=db.collection("Events");
    private EventAdapter adapter;
    View view;
    private RecyclerView recyclerView;

    private long time;
    private String date;
    private String curdate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_ongoing_, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DateFormat df = new SimpleDateFormat("d-MM-yyyy");
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
            RecyclerView recyclerView = view.findViewById(R.id.recycler_viewOngoing);
            recyclerView.setHasFixedSize(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);
        }
        else if(curdate.equals("2")){
            Query query = dbref.whereLessThanOrEqualTo("unix", time).whereGreaterThan("unix",time-900000).whereEqualTo("Day",curdate).orderBy("unix",Query.Direction.ASCENDING);

            FirestoreRecyclerOptions<EventDetail> options = new FirestoreRecyclerOptions.Builder<EventDetail>().setQuery(query, EventDetail.class)
                    .build();

            adapter = new EventAdapter(options);
            RecyclerView recyclerView = view.findViewById(R.id.recycler_viewOngoing);
            recyclerView.setHasFixedSize(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);


        }
        else{
            Query query = dbref.whereLessThanOrEqualTo("unix", time).whereGreaterThan("unix",time-900000).whereEqualTo("Day",curdate).orderBy("unix",Query.Direction.ASCENDING);
            FirestoreRecyclerOptions<EventDetail> options = new FirestoreRecyclerOptions.Builder<EventDetail>().setQuery(query, EventDetail.class)
                    .build();

            adapter = new EventAdapter(options);
            RecyclerView recyclerView = view.findViewById(R.id.recycler_viewOngoing);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
}
