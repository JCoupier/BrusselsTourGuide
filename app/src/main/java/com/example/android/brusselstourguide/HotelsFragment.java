package com.example.android.brusselstourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/** A simple {@link Fragment} subclass. */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        rootView.setBackgroundResource(R.drawable.pillow);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.hotel_brussels_belgium), getString(R.string.hotel_brussels_belgium_address),
                getString(R.string.hotel_brussels_belgium_description), R.drawable.hotel_brussels_belgium));
        locations.add(new Location(getString(R.string.radisson_blu_royal_hotel), getString(R.string.radisson_blu_royal_hotel_address),
                getString(R.string.radisson_blu_royal_hotel_description), R.drawable.radisson_blu_royal_hotel));
        locations.add(new Location(getString(R.string.hotel_metropole), getString(R.string.hotel_metropole_address),
                getString(R.string.hotel_metropole_description), R.drawable.hotel_metropole));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_hotels);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){

                // Get the {@link Location} object at the given position the user clicked on
                Location location = locations.get(position);

                // Get the data of the clicked object
                int currentImageId = location.getImageResourceId();
                String currentLocationName = location.getLocationName();
                String currentLocationAddress = location.getLocationAddress();
                String currentLocationDescription = location.getLocationDescription();

                // Call a method of MainActivity (intent) passing the data
                ((MainActivity)getActivity()).openDetails(currentImageId, currentLocationName,
                        currentLocationAddress, currentLocationDescription);
            }
        });

        return rootView;
    }
}
