package com.appsaga.vivacity2k18;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class EventAdapter extends FirestoreRecyclerAdapter<EventDetail,EventAdapter.EventHolder> {


    public EventAdapter(@NonNull FirestoreRecyclerOptions<EventDetail> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull EventHolder holder, int position, @NonNull EventDetail model) {
        holder.eventTime.setText("Time: "+model.getTime());
        holder.eventVenue.setText("Venue: "+model.getVenue());
        holder.eventDay.setText("Day "+model.getDay());
        holder.eventNameView.setText(model.getName());
        holder.eventParentView.setText(model.getParent());
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item,parent,false    );
        return new EventHolder(v);
    }

    class EventHolder extends RecyclerView.ViewHolder{
        TextView eventParentView;
        TextView eventNameView;
        TextView eventTime;
        TextView eventDay;
        TextView eventVenue;

        public EventHolder(@NonNull View itemView) {
            super(itemView);
            eventDay=itemView.findViewById(R.id.day);
            eventTime=itemView.findViewById(R.id.time);
            eventVenue=itemView.findViewById(R.id.venue);
            eventNameView=itemView.findViewById(R.id.eventname);
            eventParentView=itemView.findViewById(R.id.eventparent);
        }
    }
}

