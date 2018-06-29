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
public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("National Museum of African American History and Culture",
                "This sensational museum covers the diverse African American experience and how it helped shape the nation",
                "http://www.nmaahc.si.edu/",
                R.drawable.mus_african_american));
        //10am-5:30pm
        places.add(new Place("National Gallery of Art",
                "Two buildings. Hundreds of masterpieces. Infinite enjoyment.",
                "http://www.nga.gov/",
                R.drawable.mus_galery_art));
        //10am-5pm Mon-Sat, 11am-6pm Sun
        places.add(new Place("National Air and Space Museum",
                "Children and adults alike love walking through the Skylab Orbital Workshop and viewing the 'Apollo to the Moon' exhibit upstairs",
                "http://www.airandspace.si.edu/",
                R.drawable.mus_air_and_space));
        //10am-5:30pm
        places.add(new Place("Lincoln Memorial",
                "The words of his Gettysburg Address and Second Inaugural speech flank the huge marble statue",
                "http://www.nps.gov/linc",
                R.drawable.mus_lincoln_memorial));
        //24 hrs


        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_museums);

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
