package com.example.android.brusselstourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * LocationAdapter created by JCoupier on 25/05/2017.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    /** Resource ID for the background color for this list of locations */
    private int mColorResourceId;

    /**
     * Create a new {@link LocationAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param locations is the list of {@link Location}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public LocationAdapter(Context context, ArrayList<Location> locations, int colorResourceId) {
        super(context, 0, locations);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView locationNameTextView = (TextView) listItemView.findViewById(R.id.location_name_text_view);
        // Get the Location name from the current Location object and
        // set this text on the location name TextView
        locationNameTextView.setText(currentLocation.getLocationName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView locationAddressTextView = (TextView) listItemView.findViewById(R.id.location_address_text_view);
        // Get the Location address from the current Location object and
        // set this text on the location address TextView
        locationAddressTextView.setText(currentLocation.getLocationAddress());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the Location image from the current Location object and
        // display the provided image based on the resource ID
        imageView.setImageResource(currentLocation.getImageResourceId());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
