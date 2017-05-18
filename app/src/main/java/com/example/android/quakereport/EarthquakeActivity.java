/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        ArrayList<Earthquake> quakes = new ArrayList<>();
        quakes.add(new Earthquake("5.0", "San Fransisco", "24-Dec-2005"));
        quakes.add(new Earthquake("4.0", "San Fransisco Bay Area", "24-Dec-2007"));
        quakes.add(new Earthquake("2.9", "Redmond California", "24-sep-2005"));
        quakes.add(new Earthquake("5.0", "San Fransisco", "24-Dec-2005"));
        quakes.add(new Earthquake("5.0", "San Fransisco", "24-Dec-2005"));
        quakes.add(new Earthquake("5.0", "San Fransisco", "24-Dec-2005"));
        quakes.add(new Earthquake("5.0", "San Fransisco", "24-Dec-2005"));
        quakes.add(new Earthquake("4.4", "New York", "24-Dec-2009898"));
        quakes.add(new Earthquake("4.4", "New Delhi", "24-Dec-2009898"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        
        // create a new {@link EarthquakeAdapter] of Earthquake
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this , quakes);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeAdapter);
    }
}
