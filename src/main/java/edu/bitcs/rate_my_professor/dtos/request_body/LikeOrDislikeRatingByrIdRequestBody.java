package edu.bitcs.rate_my_professor.dtos.request_body;

public class LikeOrDislikeRatingByrIdRequestBody {
    private String action;

    public LikeOrDislikeRatingByrIdRequestBody() {
    }

    public LikeOrDislikeRatingByrIdRequestBody(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
