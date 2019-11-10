package edu.bitcs.rate_my_professor.pos;

import edu.bitcs.rate_my_professor.dtos.request_body.PostRatingRequestBody;

public class Tag {
    private long tId;
    private String tName;

    public Tag() {
    }

    public Tag(PostRatingRequestBody postRatingRequestBody) {
    }

    public Tag(long tId, String tName) {
        this.tId = tId;
        this.tName = tName;
    }

    public long gettId() {
        return tId;
    }

    public void settId(long tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
