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
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Ben’s Chili Bowl",
                "Top choice american in Logan Circle, U Street & Columbia Heights",
                "http://www.benschilibowl.com/",
                R.drawable.rest_ben_chili_bowl));
        //6am-2am Mon-Thu, to 4am Fri, 7am-4am Sat, 11am-midnight Sun
        //mains $6-10
        places.add(new Place("Dabney",
                "Top choice american in Downtown & Penn Quarter",
                "http://www.thedabney.com/",
                R.drawable.rest_thedabney));
        //5:30-10pm Tue-Thu, to 11pm Fri & Sat, 5-10pm Sun
        //small plates $14-23
        places.add(new Place("Comet Ping Pong",
                "Top choice pizza in Upper Northwest DC",
                "http://www.cometpingpong.com/",
                R.drawable.rest_comet_pingpong));
        //5-9:30pm Mon-Thu, 11:30am-10:45pm Fri & Sat, 11:30am-9:30pm Sun
        //pizzas $9-19
        places.add(new Place("Busboys & Poets",
                "Top choice cafe in Logan Circle, U Street & Columbia Heights",
                "http://www.busboysandpoets.com/",
                R.drawable.rest_busboys));
        //7am-midnight Mon-Thu, to 2am Fri, from 8am Sat & Sun
        //mains $12-21
        places.add(new Place("Bistrot du Coin",
                "Top choice french in Dupont Circle & Kalorama",
                "http://www.bistrotducoin.com/",
                R.drawable.rest_bistrotducoin));
        //11:30am-midnight Mon-Wed, 11:30am-1am Thu & Fri, noon-1am Sat, noon-midnight Sun
        //mains $20-30
        places.add(new Place("Shouk",
                "Top choice israeli in Downtown & Penn Quarter",
                "http://www.shouk.com/",
                R.drawable.rest_shouk));
        //11am-10pm
        //mains $10


        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_restaurants);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // place_listt.xml layout file.
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
