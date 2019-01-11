package com.appsaga.vivacity2k18;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new AllEvent_Fragment();
        } else if (position == 1) {
            return new DayOne_Fragment();
        } else if(position==2) {
            return new DayTwo_Fragment();
        }
        else if(position==3)
            return new DayThree_Fragment();
        else return new Ongoing_Fragment();
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return mContext.getString(R.string.AllEvents);
        } else if (position == 1) {
            return mContext.getString(R.string.Day1);
        }
        else if(position==2)
            return mContext.getString(R.string.Day2);

        else if(position==3)
            return mContext.getString(R.string.Day3);
        else {
            return mContext.getString(R.string.OnGoing);
        }
    }
}
