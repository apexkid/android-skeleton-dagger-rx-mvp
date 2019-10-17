package com.streetsmart.app.data;

import lombok.Data;

@Data
public class LeaderboardRecord {

    private int rank;
    private String name;
    private int points;
    private int image;
}
