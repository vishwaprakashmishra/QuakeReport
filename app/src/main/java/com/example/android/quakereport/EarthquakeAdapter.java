package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

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

    }
}
