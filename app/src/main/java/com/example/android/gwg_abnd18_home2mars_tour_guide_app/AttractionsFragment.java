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
        places.add(new Place("US Capitol",
                "Lively arguments fly in the Capitol's Senate and House chambers",
                "http://www.visitthecapitol.gov/",
                R.drawable.attr_us_capitol));
        //8:30am-4:30pm Mon-Sat
        places.add(new Place("White House",
                "The 'President's House', built in stages between 1792 and 1829, is an iconic, imposing building that's thrilling to see",
                "http://www.whitehouse.gov/",
                R.drawable.attr_white_house));
        //tours 7:30-11:30am Tue-Thu, to 1:30pm Fri & Sat
        places.add(new Place("United States National Arboretum",
                "The greatest green space in Washington unfurls almost 450 acres of meadowland",
                "http://www.usna.usda.gov/",
                R.drawable.attr_arboretum));
        //8am-5pm
        places.add(new Place("Georgetown Waterfront Park",
                "Offers visitors a place to enjoy river views in a lush green setting at the edge of a bustling historic urban neighborhood",
                "https://georgetownwaterfrontpark.org/",
                R.drawable.attr_georgetown_waterfront));
        //24 hrs


        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_attractions);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // place_list.xmll layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
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
