package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.pos.Course;
import edu.bitcs.rate_my_professor.pos.Rating;
import edu.bitcs.rate_my_professor.pos.Tag;

import java.util.ArrayList;
import java.util.List;

public class RatingInfoBypId {
    private long offset;
    private long limit;
    private long total;

    private Object ratings;

    private List<Link> links;

    public RatingInfoBypId() {
    }

    public RatingInfoBypId(long offset, long limit, long total, List<Rating> ratings, List<List<Tag>> tagss,
                           List<Course> courses, String pId) {

        this.offset = offset;
        this.limit = limit;
        this.total = total;

        ArrayList<RatingInfoData> ratingInfoDataArrayList = new ArrayList<>();

        for(int i=0;i<ratings.size();i++){
            RatingInfoData ratingInfoData = new RatingInfoData();

            Rating rating = ratings.get(i);
            Course course = courses.get(i);
            List <Tag> tags = tagss.get(i);

            ratingInfoData.setrDate(rating.getrDate().toString());
            ratingInfoData.setrQuality(rating.getrQuality());
            ratingInfoData.setrDifficulty(rating.getrDifficulty());
            ratingInfoData.setrClass(course.getcName());
            ratingInfoData.setrAttendance(rating.isrAttendance());
            ratingInfoData.setrTakeAgain(rating.isrTakeAgain());
            ratingInfoData.setrGradeReceived(rating.getrGradeReceived());
            ratingInfoData.setrComment(rating.getrComment());
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

        if(offset<total){
            Link linkForLoadMoreRatings = new Link("LOAD MORE RATINGS", "/ratings?pId="+pId+"&offset="+offset+"&limit="+limit);

            links.add(linkForLoadMoreRatings);

            this.links = links;
        }else{
            this.links = null;
        }

    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object getRatings() {
        return ratings;
    }

    public void setRatings(Object ratings) {
        this.ratings = ratings;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
