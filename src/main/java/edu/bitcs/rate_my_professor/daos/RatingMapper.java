package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Rating;
import edu.bitcs.rate_my_professor.pos.Tag;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

@Mapper
public interface RatingMapper {
    @Select("select Rating.rId,Rating.rCourse,Rating.rProfessor,Rating.rUser,Rating.rQuality,Rating.rDifficulty,Rating.rTakeAgain,Rating.rAttendance,Rating.rGradeReceived,Rating.rComment,Rating.rDate,Rating.rPeopleFoundUseful,Rating.rPeopleDidNotFindUseful,Course.cId,Course.cName from Rating,Course where Rating.rId = #{rId} and Rating.rCourse = Course.cId")
    Map<String,Object> getRatingAndRelatedCourseByrId(long rId);

    @Select("select Tag.tId,Tag.tName from RatingsHasTags, Tag where RatingsHasTags.rId = #{rId} and RatingsHasTags.tId = Tag.tId")
    List<Tag> getTagsByrId(long rId);

    @Select("select Rating.rId,Rating.rCourse,Rating.rProfessor,Rating.rUser,Rating.rQuality,Rating.rDifficulty,Rating.rTakeAgain,Rating.rAttendance,Rating.rGradeReceived,Rating.rComment,Rating.rDate,Rating.rPeopleFoundUseful,Rating.rPeopleDidNotFindUseful ,Course.cId,Course.cName from Rating,Course where Rating.rProfessor = #{pId} and Rating.rCourse = Course.cId order by rId limit #{offset}, #{limit}")
    List<Map<String,Object>> getRatingAndCourseBypIdWithOffsetAndLimit(long pId, long offset, long limit);

    @Select("select Rating.rId,Rating.rCourse,Rating.rProfessor,Rating.rUser,Rating.rQuality,Rating.rDifficulty,Rating.rTakeAgain,Rating.rAttendance,Rating.rGradeReceived,Rating.rComment,Rating.rDate,Rating.rPeopleFoundUseful,Rating.rPeopleDidNotFindUseful ,Course.cId,Course.cName ,Professor.pId, Professor.pFirstName, Professor.pLastName from Rating,Course,Professor where Rating.rUser = #{uId} and Rating.rProfessor = Professor.pId and Rating.rCourse = Course.cId order by rId limit #{offset}, #{limit}")
    List<Map<String,Object>> getRatingAndCourseAndProfessorByuIdWithOffsetAndLimit(long uId, long offset, long limit);

    @Select("select count(rId) from Rating")
    long getTotalNumber();

    @Select("call insertRatingAndUpdateProfessor(#{rId,mode=OUT, jdbcType=BIGINT},#{rCourse},#{rProfessor},#{rUser},#{rQuality},#{rDifficulty},#{rTakeAgain},#{rAttendance},#{rGradeReceived},#{rComment},#{rDate},#{rPeopleFoundUseful},#{rPeopleDidNotFindUseful})")
    @Options(statementType = StatementType.CALLABLE)
    void insertRatingAndUpdateProfessor(Rating rating);

    @Select("call insertRatingsHasTagsAndUpdateTagAndUpdateProfessorsHasTags(#{rId},#{tId},#{pId})")
    @Options(statementType = StatementType.CALLABLE)
    void insertRatingsHasTagsAndUpdateTagAndUpdateProfessorsHasTags(long rId, long tId, long pId);

    @Update("update Rating set rPeopleFoundUseful = rPeopleFoundUseful+1 where rId = #{rId}")
    long updateRatingLikeNumber(long rId);

    @Update("update Rating set rPeopleDidNotFindUseful = rPeopleDidNotFindUseful + 1 where rId = #{rId}")
    long updateRatingNotLikeNumber(long rId);
}
