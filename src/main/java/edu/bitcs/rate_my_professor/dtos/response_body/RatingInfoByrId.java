package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.pos.Course;
import edu.bitcs.rate_my_professor.pos.Rating;
import edu.bitcs.rate_my_professor.pos.Tag;

import java.util.ArrayList;

public class RatingInfoByrId {
    private Object ratingInfoByrId;

    public RatingInfoByrId() {
    }

    public RatingInfoByrId(Rating rating, ArrayList<Tag>tags, Course course){
        RatingInfoData ratingInfoData = new RatingInfoData();

        ratingInfoData.setrDate(rating.getrDate());
        ratingInfoData.setrQuality(rating.getrQuality());
        ratingInfoData.setrDifficulty(rating.getrDifficulty());
        ratingInfoData.setrClass(course.getName());
        ratingInfoData.setrAttendance(rating.isrAttendance());
        ratingInfoData.setrTakeAgain(rating.isrTakeAgain());
        ratingInfoData.setrGradeReceived(rating.getrGradeReceived());
        ratingInfoData.setrPeopleFoundUseful(rating.getrPeopleFoundUseful());
        ratingInfoData.setrPeopleDidNotFoundUseful(rating.getrPeopleDidNotFindUseful());

        ArrayList<String> rTags = new ArrayList<>();
        for(Tag tag:tags){
            rTags.add(tag.gettName());
        }
        ratingInfoData.setrTags(rTags);

        this.ratingInfoByrId = ratingInfoData;
    }

    public RatingInfoByrId(String ratingInfoByrId) {
        this.ratingInfoByrId = ratingInfoByrId;
    }

    public Object getRatingInfoByrId() {
        return ratingInfoByrId;
    }

    public void setRatingInfoByrId(Object ratingInfoByrId) {
        this.ratingInfoByrId = ratingInfoByrId;
    }
}
