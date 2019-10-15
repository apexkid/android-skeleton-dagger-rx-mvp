package com.streetsmart.app.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.streetsmart.app.utils.BottomNavUtil;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getName();

    protected void initBottomNavigation(Activity activity, int position) {
        BottomNavUtil.initBottomNav(activity);
        BottomNavUtil.selectItemAtLocation(activity, position);
    }

    protected void selectItemAtLocation(Activity activity, int position) {
        BottomNavUtil.selectItemAtLocation(activity, position);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
