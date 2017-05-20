package com.example.android.quakereport;

/**
 * Created by vishwa on 18/5/17.
 */

public class Earthquake {
    private String mEarthquakeMagnitude;
    private String mLocation ;
    private Long timeInMilliSeconds;

    /**
     *  constructor
     * @param earthquakeMagnitude earthquake magnitude
     * @param location  location of earthquake
     * @param timeInMilliSeconds time in millisecond in UNIX format
     */
    public Earthquake(String earthquakeMagnitude, String location , Long timeInMilliSeconds){
        mEarthquakeMagnitude = earthquakeMagnitude;
        mLocation = location;
        this.timeInMilliSeconds  = timeInMilliSeconds;
    }

    public String getEarthquakeMagnitude() {
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
