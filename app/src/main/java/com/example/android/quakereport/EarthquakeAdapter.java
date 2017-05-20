package com.example.android.quakereport;

import android.app.Activity;
import android.icu.text.SimpleDateFormat;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;

import static android.R.attr.name;
import static android.R.string.no;


public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    /**
     * default constructor for EarthquakeAdapter
     * @param context current context of the Activity
     * @param quake ArrayList of Earthquake which contain data
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> quake){
        super(context, 0 , quake);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
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

        // Find the TextView in the list_item.xml layout with the ID earthquake_location
        TextView locationTextView = (TextView) listItemview.findViewById(R.id.earthquake_location);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        locationTextView.setText(currentQuake.getLocation());

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentQuake.getTimeInMilliSeconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemview.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemview.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);



        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemview;

    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}