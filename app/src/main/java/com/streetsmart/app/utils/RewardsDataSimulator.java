package com.streetsmart.app.utils;

import com.streetsmart.app.R;
import com.streetsmart.app.data.RewardsRecord;

import java.util.ArrayList;
import java.util.List;

public class RewardsDataSimulator {

    private static List<RewardsRecord> rewards = new ArrayList<>();

    static {
        final RewardsRecord rr = new RewardsRecord();
        rr.setRewardPoint(2000);
        rr.setRewardTitle("Shopper Ninja");
        rr.setRewardType("Cashback");
        rr.setRewardValue("500");
        rr.setImage(R.drawable.undraw_gift1);
        rewards.add(rr);

        final RewardsRecord rr2 = new RewardsRecord();
        rr2.setRewardPoint(1500);
        rr2.setRewardTitle("Big table player");
        rr2.setRewardType("Discount");
        rr2.setRewardValue("10%");
        rr2.setImage(R.drawable.undraw_gift2);
        rewards.add(rr2);


        final RewardsRecord rr3 = new RewardsRecord();
        rr3.setRewardPoint(1300);
        rr3.setRewardTitle("Loyal and unstoppable");
        rr3.setRewardType("Gift card");
        rr3.setRewardValue("200");
        rr3.setImage(R.drawable.undraw_gift_card);
        rewards.add(rr3);


        final RewardsRecord rr4 = new RewardsRecord();
        rr4.setRewardPoint(1200);
        rr4.setRewardTitle("Bag it all!");
        rr4.setRewardType("Cashback");
        rr4.setRewardValue("50");
        rr4.setImage(R.drawable.undraw_xmas);
        rewards.add(rr4);


        final RewardsRecord rr5 = new RewardsRecord();
        rr5.setRewardPoint(900);
        rr5.setRewardTitle("Reward Junkie");
        rr5.setRewardType("Discount Coupon");
        rr5.setRewardValue("5%");
        rr5.setImage(R.drawable.undraw_gift_card);
        rewards.add(rr5);


        final RewardsRecord rr6 = new RewardsRecord();
        rr6.setRewardPoint(750);
        rr6.setRewardTitle("Day 1 shopper");
        rr6.setRewardType("Free shipping");
        rr6.setRewardValue("100");
        rr6.setImage(R.drawable.undraw_gift1);
        rewards.add(rr6);


        final RewardsRecord rr7 = new RewardsRecord();
        rr7.setRewardPoint(500);
        rr7.setRewardTitle("Window shopper");
        rr7.setRewardType("Cashback");
        rr7.setRewardValue("100");
        rr7.setImage(R.drawable.undraw_gift2);
        rewards.add(rr7);


        final RewardsRecord rr8 = new RewardsRecord();
        rr8.setRewardPoint(250);
        rr8.setRewardTitle("Street novice");
        rr8.setRewardType("Instant discount");
        rr8.setRewardValue("50");
        rr8.setImage(R.drawable.undraw_xmas);
        rewards.add(rr8);

    }

    public static List<RewardsRecord> getRewards() {
        return rewards;
    }
}
