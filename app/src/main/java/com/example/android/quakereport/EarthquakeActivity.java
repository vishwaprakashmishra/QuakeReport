package com.example.android.quakereport;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;

import java.util.ArrayList;
import java.util.List;


public class EarthquakeActivity extends AppCompatActivity
        implements LoaderCallbacks<List<Earthquake> > {

    /**
     * constant value for the earthquake loader ID. We can choose any
     */
    private static final int EARTHQUAKE_LOADER_ID = 1;
    /** TextView that is displayed when the list is empty */
    private TextView mEmptyStateTextView;
    /**  Loading spinner */
    private ProgressBar loadingSpinnerView;
    /**
     * tag for log message
     */
    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    // Url for earthquake data
    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=5&limit=10";
    private EarthquakeAdapter mAdapter;


    /**
     * This method used while starting the class as the name suggest
     * @param savedInstanceState it is saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new adapter that takes an empty list of earthquakes
        mAdapter  = new EarthquakeAdapter(this, new ArrayList<Earthquake>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(mAdapter);
        // Progress bar initialization
        loadingSpinnerView = (ProgressBar) findViewById(R.id.loading_spinner);

        // Empty state textView if there is no data to show
        mEmptyStateTextView = (TextView) findViewById(R.id.emptyText);
        earthquakeListView.setEmptyView(mEmptyStateTextView);
        // Set  an item click listener on the ListView, which sends an int
        // to open a website with mor einformation about the selected earthquakes.
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(EarthquakeActivity.this, "item clicked",
                        Toast.LENGTH_LONG).show();

                // Find the current earthquake that was clicked on
                Earthquake currentEarthquake = mAdapter.getItem(position);

                // Convert the String URL  into URI object (to pass into the intent constructor).
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Sending an intent to open url of detail about the Earthquake
                Intent i = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(i);

            }
        });
        // Get a reference to the LoaderManager, in order to interact
        LoaderManager loaderManager = getLoaderManager();
        // Initialize the loader
        loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
    }

    /**
     * this callback function is implementation of LoaderManager.LoaderCallback interface
     * used when loader is Initialized
     * @param i is the loader index
     * @param bundle bundle is context
     * @return returns EarthquakeLoader
     */
    @Override
    public Loader<List<Earthquake> > onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        Log.i(LOG_TAG, "in onCreateLoader");
        // creating ConnectivityManager  to check the status of Internet Connectivity
        ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        // Getting Network info
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        // checking both case of network ie is connecting of connected
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if ( !isConnected ) {
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
        return new EarthquakeLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {

        loadingSpinnerView.setVisibility(View.GONE);
        Log.i(LOG_TAG, "IN onLoadFinished and EXECUTING");
        // Clear the adapter of previous earthquake data
        mAdapter.clear();
        // creating ConnectivityManager  to check the status of Internet Connectivity
        ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Getting Network info
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        // checking both case of network ie is connecting of connected
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        // If there is a valid list of {@link Earthquake}s , then add them to the adapters.
        // data set. This will trigger the ListView to update.
        if ( earthquakes != null && !earthquakes.isEmpty()) {
            mAdapter.addAll(earthquakes );
        } else if (!isConnected) {
            mEmptyStateTextView.setText(R.string.no_internet_connection);

        } else  { // else displaying the message R.string.no_earthquake
            mEmptyStateTextView.setText(R.string.no_earthquake);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {
        Log.i(LOG_TAG, "in onLoaderReset and EXECUTING");
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }

}
