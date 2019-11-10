package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Rating;
import edu.bitcs.rate_my_professor.pos.Tag;

import java.util.ArrayList;
import java.util.Map;

public interface RatingDao extends Dao{
    Map<String,Object> getRatingAndRelatedTagsAndCourseByrId(long rId);

    Map<String,Object> getRatingsAndRelatedTagsAndCourseBypId(long pId);
    Map<String,Object> getRatingsAndRelatedTagsAndCourseBypIdWithOffsetAndLimit(long pId, long offset, long limit);

    Map<String,Object> getRatingsAndRelatedTagsAndCourseAndProfessorByuEmail(String uEMail);
    Map<String,Object> getRatingsAndRelatedTagsAndCourseAndProfessorByuEmailWithOffsetAndLimit(String uEmail, long offset, long limit);

    long getTotalNumber();

    boolean insertRatingAndRelatedTags(Rating rating, ArrayList<Tag> tags);
    boolean insertTagsBypId(ArrayList<Tag> tags);

    boolean addOneOnRatingBypId(long pId);
    boolean minusOneOnRatingBypId(long pId);

}
