package com.example.android.brusselstourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * LocationFragmentPagerAdapter created by JCoupier on 25/05/2017.
 */

public class LocationFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public LocationFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LandmarksFragment();
        } else if (position == 1){
            return new EventsFragment();
        } else if (position == 2) {
            return new RestaurantsFragment();
        } else if (position == 3) {
            return new BarsFragment();
        } else {
            return new HotelsFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_landmarks);
        } else if (position == 1) {
            return mContext.getString(R.string.category_events);
        } else if (position == 2) {
            return mContext.getString(R.string.category_restaurants);
        } else if (position == 3) {
            return mContext.getString(R.string.category_bars);
        } else {
            return mContext.getString(R.string.category_hotels);
        }
    }
}
