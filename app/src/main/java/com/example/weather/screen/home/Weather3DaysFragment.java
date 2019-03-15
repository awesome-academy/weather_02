package com.example.weather.screen.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather.R;

public class Weather3DaysFragment extends Fragment {
    private OnItemClickListener mListener;

    public Weather3DaysFragment() {
    }

    public static Weather3DaysFragment newInstance() {
        Weather3DaysFragment fragment = new Weather3DaysFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3days, container, false);
    }

    public interface OnItemClickListener {
        void onItemClicked(int position);
    }
}
