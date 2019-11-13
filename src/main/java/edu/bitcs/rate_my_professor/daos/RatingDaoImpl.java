package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Course;
import edu.bitcs.rate_my_professor.pos.Professor;
import edu.bitcs.rate_my_professor.pos.Rating;
import edu.bitcs.rate_my_professor.pos.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RatingDaoImpl implements RatingDao {
    @Autowired
    private RatingMapper ratingMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> getRatingAndRelatedTagsAndCourseByrId(long rId) {
        Map<String,Object> map = ratingMapper.getRatingAndRelatedCourseByrId(rId);

        Rating rating = new Rating((long)map.get("rId"),(long)map.get("rCourse"),(long)map.get("rProfessor"),
               (long)map.get("rUser"),(double)map.get("rQuality"),(double)map.get("rDifficulty"),
               (boolean)map.get("rTakeAgain"),(boolean)map.get("rAttendance"),(String)map.get("rGradeReceived"),
               (String)map.get("rComment"),(Date)map.get("rDate"),(int)map.get("rPeopleFoundUseful"),
                (int)map.get("rPeopleDidNotFindUseful"));

        Course course = new Course((long)map.get("cId"),(String)map.get("cName"));

        List<Tag> tags = ratingMapper.getTagsByrId(rId);

        map.put("rating",rating);
        map.put("tags", tags);
        map.put("course", course);

        return map;
    }

    @Override
    public Map<String, Object> getRatingsAndRelatedTagsAndCourseBypId(long pId) {
        return null;
    }

    @Override
    public Map<String, Object> getRatingsAndRelatedTagsAndCourseBypIdWithOffsetAndLimit(long pId, long offset, long limit) {
        List<Map<String,Object>> list = ratingMapper.getRatingAndCourseBypIdWithOffsetAndLimit(pId,offset,limit);

        List<Rating> ratings = new ArrayList<>();
        List<List<Tag>> tagss = new ArrayList<>();
        List<Course> courses = new ArrayList<>();


        for(Map<String,Object> map:list){
            Rating rating = new Rating((long)map.get("rId"),(long)map.get("rCourse"),(long)map.get("rProfessor"),
                    (long)map.get("rUser"),(double)map.get("rQuality"),(double)map.get("rDifficulty"),
                    (boolean)map.get("rTakeAgain"),(boolean)map.get("rAttendance"),(String)map.get("rGradeReceived"),
                    (String)map.get("rComment"),(Date)map.get("rDate"),(int)map.get("rPeopleFoundUseful"),
                    (int)map.get("rPeopleDidNotFindUseful"));

            List<Tag> tags = ratingMapper.getTagsByrId(rating.getrId());

            Course course = new Course((long)map.get("cId"),(String)map.get("cName"));

            ratings.add(rating);
            tagss.add(tags);
            courses.add(course);
        }

        Map<String,Object> map = new HashMap<>();

        map.put("ratings",ratings);
        map.put("tagss", tagss);
        map.put("courses", courses);

        return map;
    }

    @Override
    public Map<String, Object> getRatingsAndRelatedTagsAndCourseAndProfessorByuEmail(String uEMail) {
        return null;
    }

    @Override
    public Map<String, Object> getRatingsAndRelatedTagsAndCourseAndProfessorByuEmailWithOffsetAndLimit(String uEmail, long offset, long limit) {
        long uId = userMapper.getuIdByuEmail(uEmail);

        List<Map<String,Object>> list = ratingMapper.getRatingAndCourseAndProfessorByuIdWithOffsetAndLimit(uId, offset, limit);

        List<Rating> ratings = new ArrayList<>();
        List<List<Tag>> tagss = new ArrayList<>();
        List<Professor> professors = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        for(Map<String,Object> map:list){
            Rating rating = new Rating((long)map.get("rId"),(long)map.get("rCourse"),(long)map.get("rProfessor"),
                    (long)map.get("rUser"),(double)map.get("rQuality"),(double)map.get("rDifficulty"),
                    (boolean)map.get("rTakeAgain"),(boolean)map.get("rAttendance"),(String)map.get("rGradeReceived"),
                    (String)map.get("rComment"),(Date)map.get("rDate"),(int)map.get("rPeopleFoundUseful"),
                    (int)map.get("rPeopleDidNotFindUseful"));

            List<Tag> tags = ratingMapper.getTagsByrId(rating.getrId());

            Professor professor = new Professor();
            professor.setpId((long)map.get("pId"));
            professor.setpFirstName((String)map.get("pFirstName"));
            professor.setpLastName((String)map.get("pLastName"));

            Course course = new Course((long)map.get("cId"),(String)map.get("cName"));

            ratings.add(rating);
            tagss.add(tags);
            professors.add(professor);
            courses.add(course);
        }

        Map<String,Object> map = new HashMap<>();

        map.put("ratings",ratings);
        map.put("tagss", tagss);
        map.put("professors", professors);
        map.put("courses",courses);

        return map;
    }

    @Override
    public long getTotalNumber() {
        return ratingMapper.getTotalNumber();
    }

    @Override
    public boolean insertRatingAndRelatedTags(Rating rating, List<Tag> tags, String uEmail) {
        long uId = userMapper.getuIdByuEmail(uEmail);
        rating.setrUser(uId);

        if(ratingMapper.insertRating(rating)==0){
            return false;
        }else{
            long rId = rating.getrId();

            for(Tag tag:tags){
                if(ratingMapper.insetRatingsHasTags(rId, tag.gettId())==0){
                    return false;
                }
            }
        }


        return true;
    }

    @Override
    public boolean addOneOnRatingByrId(long rId) {
        if(ratingMapper.updateRatingLikeNumber(rId)==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean minusOneOnRatingByrId(long rId) {
        if(ratingMapper.updateRatingNotLikeNumber(rId)==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
