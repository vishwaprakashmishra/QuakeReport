package com.example.android.quakereport;

/**
 * Created by vishwa on 18/5/17.
 */

public class Earthquake {
    private float mEarthquakeMagnitude;
    private String mLocation ;
    private String mDateOfEarthquake;

    public Earthquake(float earthquakeMagnitude, String location , String dateOfEarthQuake){
        mEarthquakeMagnitude = earthquakeMagnitude;
        mLocation = location;
        mDateOfEarthquake = dateOfEarthQuake;
    }

    public float getmEarthquakeMagnitude() {
        return mEarthquakeMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmDateOfEarthquake() {
        return mDateOfEarthquake;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "mEarthquakeMagnitude=" + mEarthquakeMagnitude +
                ", mLocation='" + mLocation + '\'' +
                ", mDateOfEarthquake='" + mDateOfEarthquake + '\'' +
                '}';
    }
}
