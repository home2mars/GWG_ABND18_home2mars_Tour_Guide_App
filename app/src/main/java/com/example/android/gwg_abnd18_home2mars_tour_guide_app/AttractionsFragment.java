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
public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.attr_us_capitol_name),
                getString(R.string.attr_us_capitol_tagline),
                getString(R.string.attr_us_capitol_website),
                R.drawable.attr_us_capitol));
        //8:30am-4:30pm Mon-Sat
        places.add(new Place(getString(R.string.attr_white_house_name),
                getString(R.string.attr_white_house_tagline),
                getString(R.string.attr_white_house_website),
                R.drawable.attr_white_house));
        //tours 7:30-11:30am Tue-Thu, to 1:30pm Fri & Sat
        places.add(new Place(getString(R.string.attr_attr_arboretum_name),
                getString(R.string.attr_attr_arboretum_tagline),
                getString(R.string.attr_attr_arboretum_website),
                R.drawable.attr_arboretum));
        //8am-5pm
        places.add(new Place(getString(R.string.attr_georgetown_waterfront_name),
                getString(R.string.attr_georgetown_waterfront_tagline),
                getString(R.string.attr_georgetown_waterfront_website),
                R.drawable.attr_georgetown_waterfront));
        //24 hrs


        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_attractions);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // place_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open a browser to open the website of the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

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
