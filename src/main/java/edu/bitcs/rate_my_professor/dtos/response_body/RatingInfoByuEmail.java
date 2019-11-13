package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.pos.Course;
import edu.bitcs.rate_my_professor.pos.Professor;
import edu.bitcs.rate_my_professor.pos.Rating;
import edu.bitcs.rate_my_professor.pos.Tag;
import edu.bitcs.rate_my_professor.services.IdHelper;

import java.util.ArrayList;
import java.util.List;

public class RatingInfoByuEmail {
    private long offset;
    private long limit;
    private long total;

    private Object ratings;

    private List<Link> links;

    public RatingInfoByuEmail() {
    }

    public RatingInfoByuEmail(long offset, long limit, long total, List<Rating> ratings, List<List<Tag>> tagss,
                              List<Course> courses, List<Professor> professors) {
        class RatingInfoDataByuEmail extends RatingInfoData{
            private String rProfessor;
            private Link link;

            public RatingInfoDataByuEmail() {
            }

            public RatingInfoDataByuEmail(String rProfessor, Link link) {
                this.rProfessor = rProfessor;
                this.link = link;
            }

            public String getrProfessor() {
                return rProfessor;
            }

            public void setrProfessor(String rProfessor) {
                this.rProfessor = rProfessor;
            }

            public Link getLink() {
                return link;
            }

            public void setLink(Link link) {
                this.link = link;
            }
        }

        this.offset = offset;
        this.limit = limit;
        this.total = total;

        ArrayList<Object> ratingInfoDataByuEmailArrayList = new ArrayList<>();

        for(int i=0;i<ratings.size();i++){
            RatingInfoDataByuEmail ratingInfoDataByuEmail = new RatingInfoDataByuEmail();

            Rating rating = ratings.get(i);
            Course course = courses.get(i);
            List <Tag> tags = tagss.get(i);
            Professor professor = professors.get(i);

            ratingInfoDataByuEmail.setrDate(rating.getrDate().toString());
            ratingInfoDataByuEmail.setrQuality(rating.getrQuality());
            ratingInfoDataByuEmail.setrDifficulty(rating.getrDifficulty());
            ratingInfoDataByuEmail.setrClass(course.getcName());
            ratingInfoDataByuEmail.setrAttendance(rating.isrAttendance());
            ratingInfoDataByuEmail.setrTakeAgain(rating.isrTakeAgain());
            ratingInfoDataByuEmail.setrGradeReceived(rating.getrGradeReceived());
            ratingInfoDataByuEmail.setrComment(rating.getrComment());
            ratingInfoDataByuEmail.setrPeopleFoundUseful(rating.getrPeopleFoundUseful());
            ratingInfoDataByuEmail.setrPeopleDidNotFoundUseful(rating.getrPeopleDidNotFindUseful());

            ArrayList<String> rTags = new ArrayList<>();
            for(Tag tag:tags){
                rTags.add(tag.gettName());
            }
            ratingInfoDataByuEmail.setrTags(rTags);

            ratingInfoDataByuEmail.setrProfessor(professor.getpFirstName() + " "+ professor.getpLastName());

            Long id = professor.getpId();
            String pId = IdHelper.getStringIdFromId(id);

            Link link = new Link("GO TO PROFESSOR'S PAGE","/professors/"+pId);

            ratingInfoDataByuEmail.setLink(link);

            ratingInfoDataByuEmailArrayList.add(ratingInfoDataByuEmail);
        }

        this.ratings = ratingInfoDataByuEmailArrayList;
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
