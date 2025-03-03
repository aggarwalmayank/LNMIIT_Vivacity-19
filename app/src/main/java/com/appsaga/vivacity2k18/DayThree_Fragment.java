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

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class DayThree_Fragment extends Fragment {
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference dbref=db.collection("Events");
    private EventAdapter adapter;
    View view;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_day_three_, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private  void setupRecyclerView(){
        Query query=dbref.whereEqualTo("Day","3").orderBy("unix",Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<EventDetail> options=new FirestoreRecyclerOptions.Builder<EventDetail>().setQuery(query,EventDetail.class)
                .build();

        adapter=new EventAdapter(options);
        recyclerView=view.findViewById(R.id.recycler_viewTHREE);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
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
