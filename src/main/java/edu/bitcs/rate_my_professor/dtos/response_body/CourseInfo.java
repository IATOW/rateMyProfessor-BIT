package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.pos.Course;
import edu.bitcs.rate_my_professor.services.IdHelper;

import java.util.ArrayList;
import java.util.List;

public class CourseInfo {
    private List<Object> courseInfo;

    public CourseInfo() {
    }

    public CourseInfo(List<Course> courses){
        class CourseInfoData {
            private String cId;
            private String cName;

            public CourseInfoData() {
            }

            public CourseInfoData(String cId, String cName) {
                this.cId = cId;
                this.cName = cName;
            }

            public String getcId() {
                return cId;
            }

            public void setcId(String cId) {
                this.cId = cId;
            }

            public String getcName() {
                return cName;
            }

            public void setcName(String cName) {
                this.cName = cName;
            }
        }

        ArrayList <Object> courseInfo = new ArrayList<>();

        for(Course course:courses){
            CourseInfoData courseInfoData = new CourseInfoData();

            Long id = course.getcId();
            String cId = IdHelper.getStringIdFromId(id);

            courseInfoData.setcId(cId);
            courseInfoData.setcName(course.getcName());

            courseInfo.add(courseInfoData);
        }

        this.courseInfo = courseInfo;
    }
//
//    public CourseInfo(ArrayList<String> courseInfo) {
//        this.courseInfo = courseInfo;
//    }


    public List<Object> getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(List<Object> courseInfo) {
        this.courseInfo = courseInfo;
    }
}
