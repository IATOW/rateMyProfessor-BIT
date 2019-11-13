package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select Course.cId,cName from Course,ProfessorsTeachCourses where ProfessorsTeachCourses.pId = #{pId} and " +
            "ProfessorsTeachCourses.cId = Course.cId")
    List<Course> getCoursesBypId(long pId);

    @Select("select * from Course where cId = #{cId}")
    Course getCourseBycId(long cId);
}
