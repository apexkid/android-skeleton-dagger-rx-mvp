package com.streetsmart.app.utils;

import android.content.Context;
import android.content.Intent;

import com.streetsmart.app.activity.dashboard.DashboardActivity;
import com.streetsmart.app.activity.leaderboard.LeaderboardActivity;
import com.streetsmart.app.activity.play.PlayActivity;
import com.streetsmart.app.activity.rewards.RewardsActivity;
import com.streetsmart.app.activityUI.SplashScreenUIActivity;

public class IntentWrapper {

    public static void startDashboardActivity(Context context) {
        final Intent intent = new Intent(context, DashboardActivity.class);
        context.startActivity(intent);
    }

    public static void startLeaderboardActivity(Context context) {
        final Intent intent = new Intent(context, LeaderboardActivity.class);
        context.startActivity(intent);
    }

    public static void startRewardsActivity(Context context) {
        final Intent intent = new Intent(context, RewardsActivity.class);
        context.startActivity(intent);
    }

    public static void startPlayActivity(Context context) {
        final Intent intent = new Intent(context, PlayActivity.class);
        context.startActivity(intent);
    }

    public static void startSplashActivity(Context context) {
        final Intent intent = new Intent(context, SplashScreenUIActivity.class);
        context.startActivity(intent);
    }

}
