package com.example.android.brusselstourguide;

/**
 * Location class created by JCoupier on 25/05/2017.
 *
 * {@link Location} represents a location where the user wants to discover.
 * It contains an Image, the Name of the location, the Address of the location and a description.
 */
public class Location {

    /** Name of the location */
    private String mLocationName;

    /** Address of the location */
    private String mLocationAddress;

    /** Description of the location */
    private String mLocationDescription;

    /** Image resource ID for the location */
    private int mImageResourceId;

    /**
     * Create a new Location object.
     *
     * @param locationName is the name of the location
     * @param locationAddress is the address of the location
     * @param locationDescription is the description of the location
     * @param imageResourceId is the drawable resource ID for the image associated with the location
     */
    public Location(String locationName, String locationAddress, String locationDescription, int imageResourceId) {
        mLocationName = locationName;
        mLocationAddress = locationAddress;
        mLocationDescription = locationDescription;
        mImageResourceId = imageResourceId;
    }

    /** Get the name of the location. */
    public String getLocationName() {
        return mLocationName;
    }

    /** Get the address of the location. */
    public String getLocationAddress() {
        return mLocationAddress;
    }

    /** Get the description of the location. */
    public String getLocationDescription() {
        return mLocationDescription;
    }

    /** Return the image resource ID of the location. */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
