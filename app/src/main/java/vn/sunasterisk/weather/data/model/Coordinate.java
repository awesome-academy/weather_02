package vn.sunasterisk.weather.data.model;

public class Coordinate {
    private String mLongitude;
    private String mLatitude;

    public Coordinate() {
    }

    public Coordinate(String longitude, String latitude) {
        mLongitude = longitude;
        mLatitude = latitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }
}
