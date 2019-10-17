package com.streetsmart.app.data.api;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameResultPOSTBody {

    private String userid;
    private String gameid;
    private String starttime;
    private String endtime;
    private String totalpointsforgame;

    private List<AnswerResult> answerslist;

    @Data
    @NoArgsConstructor
    public static class AnswerResult {
        private String question_option_id;
        private String question_text;
        private String question_image_url;
        private String question_tag;
        private String option_text;
        private String option_image_url;
        private String is_selected;
        private String correct_answer;
        private String point_scored;
        private String question_type;
    }
}
