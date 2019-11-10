package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CourseDaoImpl implements CourseDao {

    @Override
    public ArrayList<Course> getCoursesBypId(long pId) {
        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course(1,"math"));
        courses.add(new Course(2,"english"));

        return courses;
    }

    @Override
    public Course getCourseBycId(long cId) {
        return null;
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
