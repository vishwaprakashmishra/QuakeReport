package com.example.android.quakereport;

/**
 * Created by vishwa on 18/5/17.
 */

public class Earthquake {
    private String mEarthquakeMagnitude;
    private String mLocation ;
    private String mDateOfEarthquake;

    public Earthquake(String earthquakeMagnitude, String location , String dateOfEarthQuake){
        mEarthquakeMagnitude = earthquakeMagnitude;
        mLocation = location;
        mDateOfEarthquake = dateOfEarthQuake;
    }

    public String getEarthquakeMagnitude() {
        return mEarthquakeMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDateOfEarthquake() {
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

    public void setEarthquakeMagnitude(String mEarthquakeMagnitude) {
        this.mEarthquakeMagnitude = mEarthquakeMagnitude;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public void setDateOfEarthquake(String mDateOfEarthquake) {
        this.mDateOfEarthquake = mDateOfEarthquake;
    }
}
