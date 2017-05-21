package com.example.android.quakereport;

import android.support.v4.app.NotificationCompat;

/**
 * Created by vishwa on 18/5/17.
 */

public class Earthquake {
    private Double mEarthquakeMagnitude;
    private String mLocation ;
    private Long timeInMilliSeconds;
    private String url ;

    /**
     *  constructor
     * @param earthquakeMagnitude earthquake magnitude
     * @param location  location of earthquake
     * @param timeInMilliSeconds time in millisecond in UNIX format
     */
    public Earthquake(Double earthquakeMagnitude, String location , Long timeInMilliSeconds, String url ){
        mEarthquakeMagnitude = earthquakeMagnitude;
        mLocation = location;
        this.timeInMilliSeconds  = timeInMilliSeconds;
        this.url = url;
    }

    public Double getEarthquakeMagnitude() {
        return mEarthquakeMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public Long getTimeInMilliSeconds() {
        return timeInMilliSeconds;
    }

    public String getUrl(){
        return url;
    }
    @Override
    public String toString() {
        return "Earthquake{" +
                "mEarthquakeMagnitude=" + mEarthquakeMagnitude +
                ", mLocation='" + mLocation + '\'' +
                ", mDateOfEarthquake='" + timeInMilliSeconds + '\'' +
                '}';
    }
}
