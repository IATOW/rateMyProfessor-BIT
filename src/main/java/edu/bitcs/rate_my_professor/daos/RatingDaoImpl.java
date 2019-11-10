package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Rating;
import edu.bitcs.rate_my_professor.pos.Tag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;

@Repository
public class RatingDaoImpl implements RatingDao {
    public final static int LIMIT = 10;

    @Override
    public Map<String, Object> getRatingAndRelatedTagsAndCourseByrId(long rId) {
        return null;
    }

    @Override
    public Map<String, Object> getRatingsAndRelatedTagsAndCourseBypId(long pId) {
        return null;
    }

    @Override
    public Map<String, Object> getRatingsAndRelatedTagsAndCourseBypIdWithOffsetAndLimit(long pId, long offset, long limit) {
        return null;
    }

    @Override
    public Map<String, Object> getRatingsAndRelatedTagsAndCourseAndProfessorByuEmail(String uEMail) {
        return null;
    }

    @Override
    public Map<String, Object> getRatingsAndRelatedTagsAndCourseAndProfessorByuEmailWithOffsetAndLimit(String uEmail, long offset, long limit) {
        return null;
    }

    @Override
    public long getTotalNumber() {
        return 0;
    }

    @Override
    public boolean insertRatingAndRelatedTags(Rating rating, ArrayList<Tag> tags) {
        return false;
    }

    @Override
    public boolean insertTagsBypId(ArrayList<Tag> tags) {
        return false;
    }

    @Override
    public boolean addOneOnRatingBypId(long pId) {
        return false;
    }

    @Override
    public boolean minusOneOnRatingBypId(long pId) {
        return false;
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
