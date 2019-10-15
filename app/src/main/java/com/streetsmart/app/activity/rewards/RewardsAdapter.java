package com.streetsmart.app.activity.rewards;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.streetsmart.app.R;
import com.streetsmart.app.data.RewardsRecord;

import java.util.List;

import lombok.Getter;

public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.RewardsViewHolder> {

    private List<RewardsRecord> rewardList;

    public RewardsAdapter(List<RewardsRecord> rewardList) {
        this.rewardList = rewardList;
    }

    @NonNull
    @Override
    public RewardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rewards_cardview, parent, false);

        return new RewardsViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardsViewHolder holder, int position) {
        final CardView cardView = holder.getCardView();

        final TextView rewardTitle = cardView.findViewById(R.id.textView_reward_title);
        final TextView rewardValue = cardView.findViewById(R.id.textView_reward_value);
        final TextView rewardType = cardView.findViewById(R.id.textView_reward_type);
        final TextView points = cardView.findViewById(R.id.textView_points);
        final ImageView image = cardView.findViewById(R.id.imageView_rewards);

        rewardTitle.setText(rewardList.get(position).getRewardTitle());
        rewardValue.setText(rewardList.get(position).getRewardValue());
        rewardType.setText(rewardList.get(position).getRewardType());
        image.setImageResource(rewardList.get(position).getImage());
        points.setText(String.format("At %s points", rewardList.get(position).getRewardPoint()));

    }

    @Override
    public int getItemCount() {
        return rewardList.size();
    }

    public class RewardsViewHolder extends RecyclerView.ViewHolder {
        @Getter
        private CardView cardView;

        public RewardsViewHolder(@NonNull CardView v) {
            super(v);
            cardView = v;
        }
    }
}
