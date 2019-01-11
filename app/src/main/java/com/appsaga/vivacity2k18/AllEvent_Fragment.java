package com.appsaga.vivacity2k18;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.appsaga.vivacity2k18.AllEventDetails;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AllEvent_Fragment extends Fragment {
    private Animation animation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //GlitchEffect.showGlitch((Activity) this.getContext());

        View rootView = inflater.inflate(R.layout.fragment_all_event_, container, false);

        final ArrayList<AllEventDetails> all = new ArrayList<>();
        all.add(new AllEventDetails(getResources().getString(R.string.dance), R.drawable.dance));//0
        all.add(new AllEventDetails(getResources().getString(R.string.fashion), R.drawable.fashion));
        all.add(new AllEventDetails(getResources().getString(R.string.art), R.drawable.art));//2
        all.add(new AllEventDetails(getResources().getString(R.string.music), R.drawable.music));//3
        all.add(new AllEventDetails(getResources().getString(R.string.drama), R.drawable.drama));//4
        all.add(new AllEventDetails(getResources().getString(R.string.imagi), R.drawable.camera));
        all.add(new AllEventDetails(getResources().getString(R.string.openmic), R.drawable.openmic));
        all.add(new AllEventDetails(getResources().getString(R.string.ifp), R.drawable.film));
        all.add(new AllEventDetails(getResources().getString(R.string.gaming), R.drawable.gaming));
        all.add(new AllEventDetails(getResources().getString(R.string.sahoyag), R.drawable.sankalp));
        all.add(new AllEventDetails(getResources().getString(R.string.masterchef), R.drawable.masterchef));
        all.add(new AllEventDetails(getResources().getString(R.string.ipl), R.drawable.ipl));


        AllEventAdapter eventsAdapter = new AllEventAdapter(getActivity(), all);

        ListView list = rootView.findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.lefttoright);
                        view.startAnimation(animation);
                        startActivity(new Intent(getContext(), DanceEvents.class));
                        break;
                    case 1:animation = AnimationUtils.loadAnimation(getContext(), R.anim.lefttoright);
                        view.startAnimation(animation);
                        startActivity(new Intent(getContext(), FashionEvents.class));
                        break;
                    case 2: animation = AnimationUtils.loadAnimation(getContext(), R.anim.lefttoright);
                        view.startAnimation(animation);
                        startActivity(new Intent(getContext(), ArtEvents.class));
                        break;
                    case 3: animation = AnimationUtils.loadAnimation(getContext(), R.anim.lefttoright);
                        view.startAnimation(animation);
                        startActivity(new Intent(getContext(), MusicEvents.class));
                        break;
                    case 4:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.lefttoright);
                        view.startAnimation(animation);
                        startActivity(new Intent(getContext(), DramaEvents.class));
                        break;
                    case 5:animation = AnimationUtils.loadAnimation(getContext(), R.anim.lefttoright);
                        view.startAnimation(animation);
                        startActivity(new Intent(getContext(), FlashFolks.class));
                        break;
                    case 7:
                        animation = AnimationUtils.loadAnimation(getContext(), R.anim.lefttoright);
                        view.startAnimation(animation);
                        startActivity(new Intent(getContext(), Ifp.class));
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                }
            }
        });


        list.setAdapter(eventsAdapter);
        return rootView;
    }
}
