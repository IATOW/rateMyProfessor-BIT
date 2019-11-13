package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Course;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CourseDao extends Dao {
    List<Course> getCoursesBypId(long pId);
    Course getCourseBycId(long cId);
}
