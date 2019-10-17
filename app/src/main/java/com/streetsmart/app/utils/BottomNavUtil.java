package com.streetsmart.app.utils;

import android.app.Activity;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.streetsmart.app.R;

public class BottomNavUtil {

    private static final String TAG = BottomNavUtil.class.getCanonicalName();

    public static final int DASHBOARD = 0;
    public static final int REWARDS = 1;
    public static final int LEADERBOARD = 2;
    private static final int NONE = -1;


    public static void initBottomNav(Activity activity) {

        // get bottom nav. Here we are hardcoding the id of nav
        final AHBottomNavigation nav = activity.findViewById(R.id.bottom_navigation);

        if (nav == null) {
            Log.w(TAG, "Looking like bottom nav is not present on this page");
            return;
        }

        // Initial settings.
        final AHBottomNavigationAdapter navigationAdapter = new AHBottomNavigationAdapter(activity, R.menu.bottom_navigation_dashboard);
        navigationAdapter.setupWithBottomNavigation(nav);
        nav.setAccentColor(activity.getResources().getColor(R.color.colorAccent));
        nav.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        addClickListeners(activity, nav);
    }

    public static void selectItemAtLocation(Activity activity, int location) {
        Log.v(TAG, "Selecting item at location = " + location);
        final AHBottomNavigation nav = activity.findViewById(R.id.bottom_navigation);
        if (nav == null) {
            Log.w(TAG, "Looking like bottom nav is not present on this page");
            return;
        }
        if(location == NONE) {
            return;
        }

        nav.setCurrentItem(location);
    }

    private static void addClickListeners(final Activity activity, final AHBottomNavigation nav) {

        nav.setOnTabSelectedListener((position, wasSelected) -> {
            Log.v(TAG, "Position was = " + position);
            switch (position) {
                case DASHBOARD:
                    Log.v("BOTTOM-NAV-CLICK", "Dashboard selected");
                    IntentWrapper.startDashboardActivity(nav.getContext());
                    break;
                case REWARDS:
                    Log.v("BOTTOM-NAV-CLICK", "Rewards selected");
                    IntentWrapper.startRewardsActivity(nav.getContext());
                    break;
                case LEADERBOARD:
                    Log.v("BOTTOM-NAV-CLICK", "Leaderboard selected");
                    IntentWrapper.startLeaderboardActivity(nav.getContext());
                    break;
                default:
                    Log.e(TAG, "This navigation option is not configured");
                    //CommonViewUtils.getErrorSnackbar(nav).show();
            }
            return true;
        });
    }

}
