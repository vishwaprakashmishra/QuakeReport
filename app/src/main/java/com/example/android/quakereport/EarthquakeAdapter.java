package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.icu.text.DecimalFormat;
import android.icu.text.SimpleDateFormat;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.getColor;
import static com.example.android.quakereport.R.id.magnitude;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPERATOR = " of ";

    /**
     * default constructor for EarthquakeAdapter
     *
     * @param context current context of the Activity
     * @param quake   ArrayList of Earthquake which contain data
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> quake) {
        super(context, 0, quake);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // check if the existing view is being reused, otherwise inflate
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item
                    , parent, false);

        }
        // get the object located at the
        Earthquake currentQuake = getItem(position);
        // after getting the currentQuake
        // we can change the view of the current quake

        // Find the TextView with view ID magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(magnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuake.getEarthquakeMagnitude());

        // set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentQuake.getEarthquakeMagnitude());
        // Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(formattedMagnitude);


        // getting the location string ;
        String locationString, offsetToLocation;
        String location = currentQuake.getLocation();
        String[] locationArray = new String[2];
        if (location.contains(LOCATION_SEPERATOR)) {
            // Split the string into different parts ( as an array of string )
            // based on the " of " text , We expect an array of 2 string
            // the first String will be "5km N " and the second String location
            locationArray = location.split(LOCATION_SEPERATOR);
            // Location offset should be "5km N" + " of " --> "5km N of "
            offsetToLocation = locationArray[0] + LOCATION_SEPERATOR;
            // primary Location should be "Cairo, Egypt"
            locationString = locationArray[1];
        } else {
            // Otherwise , there is no " of " text in the original location
            // Hence , set the default location offset to say "Near
            offsetToLocation = getContext().getString(R.string.near_the);
            // The primary location will be the full location string
            locationString = location;
        }

        // Find the TextView in the list_item.xml layout with the ID earthquake_location
        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        offsetTextView.setText(offsetToLocation);
        // Find the TextView of location
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        // set location text on the text view
        locationTextView.setText(locationString);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentQuake.getTimeInMilliSeconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }

    private int getMagnitudeColor(Double earthquakeMagnitude) {
        int magnitude = ((int) Math.floor(earthquakeMagnitude));

        switch (magnitude) {
            case 0:
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            default:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);

        }
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

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}