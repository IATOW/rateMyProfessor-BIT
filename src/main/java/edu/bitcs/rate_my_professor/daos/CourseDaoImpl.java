package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getCoursesBypId(long pId) {
        return courseMapper.getCoursesBypId(pId);
    }

    @Override
    public Course getCourseBycId(long cId) {
        return courseMapper.getCourseBycId(cId);
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
