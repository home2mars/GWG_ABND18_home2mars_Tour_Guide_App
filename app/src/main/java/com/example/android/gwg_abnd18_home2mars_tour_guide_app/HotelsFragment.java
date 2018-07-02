package com.example.android.gwg_abnd18_home2mars_tour_guide_app;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.hotel_luxury_hay_adams_name),
                getString(R.string.hotel_luxury_hay_adams_tagline),
                getString(R.string.hotel_luxury_hay_adams_website),
                R.drawable.hotel_luxury_hay_adams));
        places.add(new Place(getString(R.string.hotel_luxury_watergate_name),
                getString(R.string.hotel_luxury_watergate_tagline),
                getString(R.string.hotel_luxury_watergate_website),
                R.drawable.hotel_luxury_watergate));
        places.add(new Place(getString(R.string.hotel_luxury_jefferson_name),
                getString(R.string.hotel_luxury_jefferson_tagline),
                getString(R.string.hotel_luxury_jefferson_website),
                R.drawable.hotel_luxury_jefferson));
        places.add(new Place(getString(R.string.hotel_luxury_st_regis_name),
                getString(R.string.hotel_luxury_st_regis_tagline),
                getString(R.string.hotel_luxury_st_regis_website),
                R.drawable.hotel_luxury_st_regis));
        places.add(new Place(getString(R.string.hotel_medium_carlyle_name),
                getString(R.string.hotel_medium_carlyle_tagline),
                getString(R.string.hotel_medium_carlyle_website),
                R.drawable.hotel_medium_carlyle));
        places.add(new Place(getString(R.string.hotel_medium_pod_dc_name),
                getString(R.string.hotel_medium_pod_dc_tagline),
                getString(R.string.hotel_medium_pod_dc_website),
                R.drawable.hotel_medium_pod_dc));
        places.add(new Place(getString(R.string.hotel_medium_phoenix_park_name),
                getString(R.string.hotel_medium_phoenix_park_tagline),
                getString(R.string.hotel_medium_phoenix_park_website),
                R.drawable.hotel_medium_phoenix_park));
        places.add(new Place(getString(R.string.hotel_medium_tabard_inn_name),
                getString(R.string.hotel_medium_tabard_inn_tagline),
                getString(R.string.hotel_medium_tabard_inn_website),
                R.drawable.hotel_medium_tabard_inn));
        places.add(new Place(getString(R.string.hotel_budget_hostelling_international_name),
                getString(R.string.hotel_budget_hostelling_international_tagline),
                getString(R.string.hotel_budget_hostelling_international_website),
                R.drawable.hotel_budget_hostelling_international));
        places.add(new Place(getString(R.string.hotel_budget_adam_inn_name),
                getString(R.string.hotel_budget_adam_inn_tagline),
                getString(R.string.hotel_budget_adam_inn_website),
                R.drawable.hotel_budget_adam_inn));
        places.add(new Place(getString(R.string.hotel_budget_highroad_hostel_name),
                getString(R.string.hotel_budget_highroad_hostel_tagline),
                getString(R.string.hotel_budget_highroad_hostel_website),
                R.drawable.hotel_budget_highroad_hostel));
        places.add(new Place(getString(R.string.hotel_budget_william_penn_house_name),
                getString(R.string.hotel_budget_william_penn_house_tagline),
                getString(R.string.hotel_budget_william_penn_house_website),
                R.drawable.hotel_budget_william_penn_house));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_hotels);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // place_list.xmll layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open a browser to open the website of the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Place} object at the given position the user clicked on
                Place place = places.get(position); //this could be shortened but leave it here for clarity

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(place.getWebsite()));
                try {
                    getContext().startActivity(intent);
                } catch (ActivityNotFoundException ex){
                    Toast.makeText(getContext(), R.string.no_browser_app_message, Toast.LENGTH_LONG).show();
                }
            }
        });

        return rootView;
    }

}
