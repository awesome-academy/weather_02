package vn.sunasterisk.weather.screen.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import vn.sunasterisk.weather.data.model.Coordinate;

public class HomeViewModel extends AndroidViewModel {
    private MutableLiveData<Coordinate> mCoordinate = new MutableLiveData<>();
    private MutableLiveData<String> mCoordinateErr = new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void start() {
        loadLocationCoodinate();
    }

    public void loadLocationCoodinate() {
        Repository.getInstance().getCoordinates(new DataSource.CoordinateCallback() {
            @Override
            public void onSuccess(Coordinate coordinate) {
                mCoordinate.setValue(coordinate);
            }

            @Override
            public void onFailed(Exception e) {
                mCoordinateErr.setValue(e.getMessage());
            }
        });
    }

    public void getCityInfo() {
        loadLocationCoodinate();
    }

    public MutableLiveData<Coordinate> getCoordinate() {
        return mCoordinate;
    }

    public MutableLiveData<String> getCoordinateErr() {
        return mCoordinateErr;
    }
}
