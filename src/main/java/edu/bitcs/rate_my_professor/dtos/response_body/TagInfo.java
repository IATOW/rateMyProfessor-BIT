package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.pos.Tag;

import java.util.ArrayList;

public class TagInfo {
    private Object tTags;

    public TagInfo() {
    }

    public TagInfo(ArrayList<Tag> tags) {
        this.tTags = tags;
    }

    public TagInfo(Object tTags) {
        this.tTags = tTags;
    }

    public Object gettTags() {
        return tTags;
    }

    public void settTags(Object tTags) {
        this.tTags = tTags;
    }
}
