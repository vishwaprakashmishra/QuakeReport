package com.example.android.quakereport;

import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by vishwa on 8/18/17.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake> > {

    /* tag for log message */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /* Url to download data */
    private String loadUrl = null;

    /**
     * EarthquakeLoader constructor
     * @param context of the activity
     * @param url data to download from
     */
    public EarthquakeLoader(Context context,String url) {
        super(context);
        loadUrl = url ;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {

        // Don't load if the url is empty ie null
        if ( loadUrl == null ) {
            return null;
        }
        // Perform network request parse the response and return the result
        List<Earthquake> result = QueryUtils.fetchEarthquakeData(loadUrl);
        return result;
    }
}
