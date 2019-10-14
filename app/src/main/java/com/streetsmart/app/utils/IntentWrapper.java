package com.streetsmart.app.utils;

import android.content.Context;
import android.content.Intent;

import com.streetsmart.app.activity.dashboard.DashboardActivity;

public class IntentWrapper {

    public static void startDashboardActivity(Context context) {
        final Intent intent = new Intent(context, DashboardActivity.class);
        context.startActivity(intent);
    }

}
