package com.example.android.brusselstourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Get the data passed by the MainActivity
        Bundle bundle = getIntent().getExtras();
        int ImageResourceId = bundle.getInt("ImageId");
        String LocationNameText = bundle.getString("LocationName");
        String LocationAddressText = bundle.getString("LocationAddress");
        String LocationDescriptionText = bundle.getString("LocationDescription");

        // Find the ImageView of activity_details layout
        ImageView detailsImage = (ImageView) findViewById(R.id.details_image);
        // Change the image according to the data passed by the MainActivity
        detailsImage.setImageResource(ImageResourceId);

        // Find the TextView of the activity_details layout to display the location name
        TextView detailsLocationName = (TextView) findViewById(R.id.details_location_name);
        // Change the text according to the data passed by the MainActivity
        detailsLocationName.setText(LocationNameText);

        // Find the TextView of the activity_details layout to display the location address
        TextView detailsLocationAddress = (TextView) findViewById(R.id.details_location_address);
        // Change the text according to the data passed by the MainActivity
        detailsLocationAddress.setText(LocationAddressText);

        // Find the TextView of the activity_details layout to display the location description
        TextView detailsLocationDescription = (TextView) findViewById(R.id.details_location_description);
        // Change the text according to the data passed by the MainActivity
        detailsLocationDescription.setText(LocationDescriptionText);

    }

    /** React to the user tapping the back/up icon in the action bar */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                // Making the transition to be a slide type from left to right (see @anim folder)
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
