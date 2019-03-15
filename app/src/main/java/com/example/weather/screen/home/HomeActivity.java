package com.example.weather.screen.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.weather.R;

public class HomeActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mFragmentManager = getSupportFragmentManager();
        setUpFragment();
    }

    private void setUpFragment() {
        HomeFragment homeFragment = (HomeFragment) mFragmentManager
                .findFragmentById(R.id.frame_home);
        if (homeFragment == null) {
            homeFragment = HomeFragment.getInstance();
        }
        replaceFragment(mFragmentManager, homeFragment, R.id.frame_home);
    }

    private void replaceFragment(FragmentManager supportFragmentManager, Fragment fragment,
                                 int frame_fragment_main) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(frame_fragment_main, fragment)
                .addToBackStack(null);
        transaction.commit();
    }
}
