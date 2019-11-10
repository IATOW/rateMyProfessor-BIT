package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.pos.Course;
import edu.bitcs.rate_my_professor.pos.Rating;
import edu.bitcs.rate_my_professor.pos.Tag;

import java.util.ArrayList;

public class RatingInfoBypId {
    private long offset;
    private long limit;
    private long total;

    private ArrayList<RatingInfoData> ratings;

    private ArrayList<Link> links;

    public RatingInfoBypId() {
    }

    public RatingInfoBypId(long offset, long limit, long total, ArrayList<Rating> ratings, ArrayList<ArrayList<Tag>> tagss,
                           ArrayList<Course> courses, String pId) {

        this.offset = offset;
        this.limit = limit;
        this.total = total;

        ArrayList<RatingInfoData> ratingInfoDataArrayList = new ArrayList<>();

        for(int i=0;i<ratings.size();i++){
            RatingInfoData ratingInfoData = new RatingInfoData();

            Rating rating = ratings.get(i);
            Course course = courses.get(i);
            ArrayList <Tag> tags = tagss.get(i);

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

            ratingInfoDataArrayList.add(ratingInfoData);
        }

        this.ratings = ratingInfoDataArrayList;

        ArrayList<Link> links = new ArrayList<>();

        offset += limit;
        Link linkForLoadMoreRatings = new Link("LOAD MORE RATINGS", "/ratings?pId="+pId+"&offset="+offset+"&limit="+limit);

        links.add(linkForLoadMoreRatings);

        this.links = links;
    }
}
