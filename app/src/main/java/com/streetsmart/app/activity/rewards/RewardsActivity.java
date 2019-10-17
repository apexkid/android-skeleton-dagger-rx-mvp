package com.streetsmart.app.activity.rewards;

import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.BaseActivity;
import com.streetsmart.app.utils.RewardsDataSimulator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RewardsActivity extends BaseActivity {

    private RewardsAdapter adapter;

    @BindView(R.id.rewards_recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        ButterKnife.bind(this);

        initBottomNavigation(this, 1);

        adapter = new RewardsAdapter(RewardsDataSimulator.getRewards());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
