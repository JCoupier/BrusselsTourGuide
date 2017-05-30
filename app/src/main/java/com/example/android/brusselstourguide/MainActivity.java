package com.example.android.brusselstourguide;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        LocationFragmentPagerAdapter adapter = new LocationFragmentPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     *
     * @param ImageId is the image resource ID of the object
     * @param LocationName is the name of the location of the object
     * @param LocationAddress is the address of the location of the object
     * @param LocationDescription is the description of the location of the object
     */
    public void openDetails (int ImageId, String LocationName, String LocationAddress, String LocationDescription){

        // Intent to open the DetailsActivity
        Intent detailsActivity = new Intent(this, DetailsActivity.class);
        // The data to be passed to the DetailsActivity
        detailsActivity.putExtra("ImageId", ImageId);
        detailsActivity.putExtra("LocationName", LocationName);
        detailsActivity.putExtra("LocationAddress", LocationAddress);
        detailsActivity.putExtra("LocationDescription", LocationDescription);
        if (detailsActivity.resolveActivity(getPackageManager()) != null) {
            startActivity(detailsActivity);
            // Making the transition to be a slide type from left to right (see @anim folder)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }
}
