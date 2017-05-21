package com.example.android.quakereport;

import android.support.v4.app.NotificationCompat;

/**
 * Created by vishwa on 18/5/17.
 */

public class Earthquake {
    private Double mEarthquakeMagnitude;
    private String mLocation ;
    private Long timeInMilliSeconds;

    /**
     *  constructor
     * @param earthquakeMagnitude earthquake magnitude
     * @param location  location of earthquake
     * @param timeInMilliSeconds time in millisecond in UNIX format
     */
    public Earthquake(Double earthquakeMagnitude, String location , Long timeInMilliSeconds){
        mEarthquakeMagnitude = earthquakeMagnitude;
        mLocation = location;
        this.timeInMilliSeconds  = timeInMilliSeconds;
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

    @Override
    public String toString() {
        return "Earthquake{" +
                "mEarthquakeMagnitude=" + mEarthquakeMagnitude +
                ", mLocation='" + mLocation + '\'' +
                ", mDateOfEarthquake='" + timeInMilliSeconds + '\'' +
                '}';
    }
}
