package com.streetsmart.app.utils;

import com.streetsmart.app.R;
import com.streetsmart.app.data.LeaderboardRecord;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardDataSimulator {

    private static final List<LeaderboardRecord> leaderboardList = new ArrayList<>();

    static  {
        final LeaderboardRecord lr1 = new LeaderboardRecord();
        lr1.setRank(1);
        lr1.setPoints(11928);
        lr1.setName("Walter White");
        lr1.setImage(R.drawable.walterwhite);
        leaderboardList.add(lr1);

        final LeaderboardRecord lr2 = new LeaderboardRecord();
        lr2.setRank(2);
        lr2.setPoints(9877);
        lr2.setName("Bruce Wayne");
        lr2.setImage(R.drawable.brucewayne);
        leaderboardList.add(lr2);

        final LeaderboardRecord lr3 = new LeaderboardRecord();
        lr3.setRank(3);
        lr3.setPoints(9088);
        lr3.setName("Richard Feynman");
        lr3.setImage(R.drawable.richardfeynman);
        leaderboardList.add(lr3);

        final LeaderboardRecord lr4 = new LeaderboardRecord();
        lr4.setRank(4);
        lr4.setPoints(8899);
        lr4.setName("Donald Trump");
        lr4.setImage(R.drawable.trump);
        leaderboardList.add(lr4);

        final LeaderboardRecord lr5 = new LeaderboardRecord();
        lr5.setRank(5);
        lr5.setPoints(8090);
        lr5.setName("Billy Joel");
        lr5.setImage(R.drawable.billy);
        leaderboardList.add(lr5);


        final LeaderboardRecord lr6 = new LeaderboardRecord();
        lr6.setRank(6);
        lr6.setPoints(7344);
        lr6.setName("Drake Reymore");
        lr6.setImage(R.drawable.drake);
        leaderboardList.add(lr6);


        final LeaderboardRecord lr7 = new LeaderboardRecord();
        lr7.setRank(7);
        lr7.setPoints(6900);
        lr7.setName("Doug McMillon");
        lr7.setImage(R.drawable.doug);
        leaderboardList.add(lr7);


        final LeaderboardRecord lr8 = new LeaderboardRecord();
        lr8.setRank(8);
        lr8.setPoints(6100);
        lr8.setName("Steve Rogers");
        lr8.setImage(R.drawable.steve);
        leaderboardList.add(lr8);

        final LeaderboardRecord lr9 = new LeaderboardRecord();
        lr9.setRank(9);
        lr9.setPoints(5700);
        lr9.setName("Sachin Bansal");
        lr9.setImage(R.drawable.billy);
        leaderboardList.add(lr9);

        final LeaderboardRecord lr10 = new LeaderboardRecord();
        lr10.setRank(10);
        lr10.setPoints(4100);
        lr10.setName("Mukesh Ambani");
        lr10.setImage(R.drawable.richardfeynman);
        leaderboardList.add(lr10);

//        final LeaderboardRecord lr11 = new LeaderboardRecord();
//        lr11.setRank(11);
//        lr11.setPoints(4000);
//        lr11.setName("Sachin Tendulkar");
//        lr11.setImage(R.drawable.brucewayne);
//        leaderboardList.add(lr11);

    }

    public static List<LeaderboardRecord> getData() {
        return leaderboardList;
    }
}
