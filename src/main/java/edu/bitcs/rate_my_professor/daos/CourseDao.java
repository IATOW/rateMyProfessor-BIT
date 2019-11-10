package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Course;
import org.springframework.lang.Nullable;

import java.util.ArrayList;

public interface CourseDao extends Dao {
    ArrayList<Course> getCoursesBypId(long pId);
    Course getCourseBycId(long cId);
}
