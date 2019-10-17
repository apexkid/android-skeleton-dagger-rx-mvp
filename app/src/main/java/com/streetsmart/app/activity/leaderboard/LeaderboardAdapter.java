package com.streetsmart.app.activity.leaderboard;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.streetsmart.app.R;
import com.streetsmart.app.data.LeaderboardRecord;

import java.util.List;

import lombok.Getter;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private List<LeaderboardRecord> leaderboardRecordList;

    public LeaderboardAdapter(List<LeaderboardRecord> leaderboardRecordList) {
        this.leaderboardRecordList = leaderboardRecordList;
    }

    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_leaderboard_cardview, parent, false);
        return new LeaderboardViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        CardView cardView = holder.view;

        final TextView rank = cardView.findViewById(R.id.textView_rank);
        final TextView name = cardView.findViewById(R.id.textView_name);
        final TextView points = cardView.findViewById(R.id.textView_points);
        final ImageView image = cardView.findViewById(R.id.leaderboard_profile_image);

        rank.setText(String.valueOf(leaderboardRecordList.get(position).getRank()));
        name.setText(leaderboardRecordList.get(position).getName());
        points.setText(String.valueOf(leaderboardRecordList.get(position).getPoints()));
        image.setImageResource(leaderboardRecordList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return leaderboardRecordList.size();
    }


    public class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        @Getter
        CardView view;
        public LeaderboardViewHolder(@NonNull CardView v) {
            super(v);
            view = v;
        }
    }
}
