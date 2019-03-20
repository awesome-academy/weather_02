package com.example.weather.screen.home;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.weather.R;

public class HomeActivity extends AppCompatActivity {
    public static String[] permissions = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};
    private final int REQUEST_CODE = 999;
    private FragmentManager mFragmentManager;
    private HomeViewModel mHomeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mFragmentManager = getSupportFragmentManager();
        mHomeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        checkPermission();
    }

    private void loadComponents() {
        mHomeViewModel.start();
        setUpFragment();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE:
                loadComponents();
                break;
            default:
                break;
        }
    }

    public void checkPermission() {
        if (ActivityCompat.checkSelfPermission(HomeActivity.this, permissions[0])
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(HomeActivity.this, permissions[1]) !=
                PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                request_permission();
            }
        } else {
            loadComponents();
        }
    }

    private void request_permission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(HomeActivity.this,
                permissions[0]) ||
                ActivityCompat.shouldShowRequestPermissionRationale(HomeActivity.this,
                        permissions[1])) {

            Snackbar.make(findViewById(R.id.root_layout),
                    getResources().getString(R.string.message),
                    Snackbar.LENGTH_LONG)
                    .setAction("retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                requestPermissions(permissions, 10);
                            }
                        }
                    }).show();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissions, REQUEST_CODE);
            }
        }
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
