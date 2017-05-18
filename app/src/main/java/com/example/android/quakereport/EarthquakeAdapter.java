package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.name;

/**
 * Created by vishwa on 18/5/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> quake){
        super(context, 0 , quake);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // check if the existing view is being reused, otherwise inflate
        View listItemview = convertView;
        if( listItemview == null){
            listItemview = LayoutInflater.from(getContext()).inflate(R.layout.list_item
            , parent, false );

        }
        // get the object located at the
        Earthquake currentQuake = getItem(position);
        // after getting the currentQuake
        // we can change the view of the current quake

        // Find the Text view in the list_item
        // with earthquake_magnitude
        TextView magnitudeTextview = (TextView) listItemview.findViewById(R.id.earthquake_magnitude);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        magnitudeTextview.setText( currentQuake.getEarthquakeMagnitude());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView locationTextView = (TextView) listItemview.findViewById(R.id.earthquake_location);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        locationTextView.setText(currentQuake.getLocation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        TextView dateTextView = (TextView) listItemview.findViewById(R.id.earthquake_date);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        dateTextView.setText( currentQuake.getDateOfEarthquake());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemview;

    }
}