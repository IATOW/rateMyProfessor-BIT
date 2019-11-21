package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.pos.Tag;
import edu.bitcs.rate_my_professor.services.IdHelper;

import java.util.ArrayList;
import java.util.List;

public class TagInfo {
    private Object tTags;

    public TagInfo() {
    }

    public TagInfo(ArrayList<Tag> tags) {
        class TagInfoData{
            private String tId;
            private String tName;

            public TagInfoData() {
            }

            public TagInfoData(String tId, String tName) {
                this.tId = tId;
                this.tName = tName;
            }

            public String gettId() {
                return tId;
            }

            public void settId(String tId) {
                this.tId = tId;
            }

            public String gettName() {
                return tName;
            }

            public void settName(String tName) {
                this.tName = tName;
            }
        }

        List<TagInfoData> tTags = new ArrayList<>();

        for(Tag tag:tags){
            tTags.add(new TagInfoData(IdHelper.getStringIdFromId(tag.gettId()),tag.gettName()));
        }

        this.tTags = tTags;
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
