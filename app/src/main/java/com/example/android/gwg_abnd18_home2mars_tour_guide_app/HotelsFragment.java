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
        places.add(new Place("Hay-Adams Hotel ($$$)",
                "Top choice heritage hotel in White House Area & Foggy Bottom",
                "http://www.hayadams.com/",
                R.drawable.hotel_luxury_hay_adams));
        places.add(new Place("Watergate Hotel ($$$)",
                "Top choice design hotel in White House Area & Foggy Bottom",
                "http://www.thewatergatehotel.com/",
                R.drawable.hotel_luxury_watergate));
        places.add(new Place("The Jefferson ($$$)",
                "Top choice hotel in Dupont Circle & Kalorama",
                "http://www.jeffersondc.com/",
                R.drawable.hotel_luxury_jefferson));
        places.add(new Place("St Regis Washington ($$$)",
                "Hotel in White House Area & Foggy Bottom",
                "http://www.stregiswashingtondc.com/",
                R.drawable.hotel_luxury_st_regis));
        places.add(new Place("Kimpton Carlyle ($$)",
                "Hotel in Dupont Circle & Kalorama",
                "http://www.carlylehoteldc.com/",
                R.drawable.hotel_medium_carlyle));
        places.add(new Place("Pod DC Hotel ($$)",
                "Top choice design hotel in Downtown & Penn Quarter",
                "http://www.thepodhotel.com/",
                R.drawable.hotel_medium_pod_dc));
        places.add(new Place("Phoenix Park Hotel ($$)",
                "Hotel in Capitol Hill & South DC",
                "http://www.phoenixparkhotel.com/",
                R.drawable.hotel_medium_phoenix_park));
        places.add(new Place("Tabard Inn ($$)",
                "Boutique hotel in Dupont Circle & Kalorama",
                "http://www.tabardinn.com/",
                R.drawable.hotel_medium_tabard_inn));
        places.add(new Place("Hosteling International ($)",
                "Top choice hostel in Downtown & Penn Quarter",
                "http://www.hiwashingtondc.org/",
                R.drawable.hotel_budget_hostelling_international));
        places.add(new Place("Adam's Inn ($)",
                "B&B in Adams Morgan",
                "http://www.adamsinn.com/",
                R.drawable.hotel_budget_adam_inn));
        places.add(new Place("Highroad Hostel ($)",
                "Hostel in Adams Morgan",
                "http://www.highroadhostels.com/",
                R.drawable.hotel_budget_highroad_hostel));
        places.add(new Place("William Penn House ($)",
                "Quaker-run guesthouse in Capitol Hill & South DC",
                "http://www.williampennhouse.org/",
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
