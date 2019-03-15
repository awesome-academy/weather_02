package com.example.weather.screen.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather.R;

public class NextDayWeatherFragment extends Fragment {
    private OnItemClickListener mListener;

    public NextDayWeatherFragment() {
    }

    public static NextDayWeatherFragment newInstance() {
        return new NextDayWeatherFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_next_day, container, false);
    }

    public interface OnItemClickListener {
        void onItemClicked(int position);
    }
}
