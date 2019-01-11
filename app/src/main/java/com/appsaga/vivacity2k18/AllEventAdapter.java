package com.appsaga.vivacity2k18;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class AllEventAdapter extends ArrayAdapter<AllEventDetails> {
    AllEventDetails currentEvent;

    AllEventAdapter(Context context, ArrayList<AllEventDetails> event) {

        super(context, 0, event);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.all_event_view, parent, false);
        }

        currentEvent = getItem(position);
        CircleImageView circleImageView=listItemView.findViewById(R.id.event_image);
        circleImageView.setImageResource(currentEvent.getImageID());

        TextView txtview=listItemView.findViewById(R.id.event_name);
        txtview.setText(currentEvent.getEvent());

        return listItemView;
    }

}
