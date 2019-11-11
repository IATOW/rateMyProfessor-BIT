package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Course;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface CourseMapper {
    @Select("sel")
    ArrayList<Course> getCoursesBypId(long pId);
}
