package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.pos.Tag;

import java.util.ArrayList;

public class TagInfoBypId {
    private Object tTags;

    public TagInfoBypId() {
    }

    public TagInfoBypId(ArrayList<Tag> tags,ArrayList<Integer> numbers) {
        class TagInfoBypIdData{
            private String tName;
            private int tNumber;

            public TagInfoBypIdData() {
            }

            public TagInfoBypIdData(String tName, int tNumber) {
                this.tName = tName;
                this.tNumber = tNumber;
            }

            public String gettName() {
                return tName;
            }

            public void settName(String tName) {
                this.tName = tName;
            }

            public int gettNumber() {
                return tNumber;
            }

            public void settNumber(int tNumber) {
                this.tNumber = tNumber;
            }
        }

        ArrayList<TagInfoBypIdData> tagInfoBypIdDataArrayList = new ArrayList<>();

        for(int i=0;i<tags.size();i++){
            TagInfoBypIdData tagInfoBypIdData = new TagInfoBypIdData(tags.get(i).gettName(),
                    numbers.get(i));

            tagInfoBypIdDataArrayList.add(tagInfoBypIdData);
        }

        this.tTags = tagInfoBypIdDataArrayList;
    }

    public TagInfoBypId(Object tTags) {
        this.tTags = tTags;
    }

    public Object gettTags() {
        return tTags;
    }

    public void settTags(Object tTags) {
        this.tTags = tTags;
    }
}
