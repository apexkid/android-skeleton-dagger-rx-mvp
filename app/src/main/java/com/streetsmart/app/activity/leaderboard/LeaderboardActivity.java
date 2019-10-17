package com.streetsmart.app.activity.leaderboard;

import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.BaseActivity;
import com.streetsmart.app.utils.LeaderboardDataSimulator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaderboardActivity extends BaseActivity {


    @BindView(R.id.leaderboard_recycler)
    RecyclerView recyclerView;

    private LeaderboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        ButterKnife.bind(this);

        initBottomNavigation(this, 2);

        adapter = new LeaderboardAdapter(LeaderboardDataSimulator.getData());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
