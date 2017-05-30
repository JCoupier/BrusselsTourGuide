package com.example.android.brusselstourguide;

import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/** A simple {@link Fragment} subclass. */
public class LandmarksFragment extends Fragment {

    public LandmarksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        rootView.setBackgroundResource(R.drawable.belgium);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.grand_place), getString(R.string.grand_place_address),
                getString(R.string.grand_place_description), R.drawable.grand_place));
        locations.add(new Location(getString(R.string.manneken_pis), getString(R.string.manneken_pis_address),
                getString(R.string.manneken_pis_description), R.drawable.manneken_pis));
        locations.add(new Location(getString(R.string.atomium), getString(R.string.atomium_address),
                getString(R.string.atomium_description), R.drawable.atomium));
        locations.add(new Location(getString(R.string.mini_europe), getString(R.string.mini_europe_address),
                getString(R.string.mini_europe_description), R.drawable.mini_europe));
        locations.add(new Location(getString(R.string.parc_cinquantenaire), getString(R.string.parc_cinquantenaire_address),
                getString(R.string.parc_cinquantenaire_description), R.drawable.parc_cinquantenaire));
        locations.add(new Location(getString(R.string.musical_instrument_museum), getString(R.string.musical_instrument_museum_address),
                getString(R.string.musical_instrument_museum_description), R.drawable.musical_instrument_museum));
        locations.add(new Location(getString(R.string.cathedral_michael_gudula), getString(R.string.cathedral_michael_gudula_address),
                getString(R.string.cathedral_michael_gudula_description), R.drawable.cathedral_michael_gudula));
        locations.add(new Location(getString(R.string.belgian_comic_strip_center), getString(R.string.belgian_comic_strip_center_address),
                getString(R.string.belgian_comic_strip_center_description), R.drawable.belgian_comic_strip_center));
        locations.add(new Location(getString(R.string.royal_greenhouses_laeken), getString(R.string.royal_greenhouses_laeken_address),
                getString(R.string.royal_greenhouses_laeken_description), R.drawable.royal_greenhouses_laeken));
        locations.add(new Location(getString(R.string.royal_palace_brussels), getString(R.string.royal_palace_brussels_address),
                getString(R.string.royal_palace_brussels_description), R.drawable.royal_palace_brussels));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_landmarks);

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
