package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.pos.Course;
import edu.bitcs.rate_my_professor.services.IdHelper;

import java.util.ArrayList;

public class CourseInfo {
    private ArrayList<Object> courseInfo;

    public CourseInfo() {
    }

    public CourseInfo(ArrayList<Course> courses){
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
            courseInfoData.setcName(course.getName());

            courseInfo.add(courseInfoData);
        }

        this.courseInfo = courseInfo;
    }
//
//    public CourseInfo(ArrayList<String> courseInfo) {
//        this.courseInfo = courseInfo;
//    }


    public ArrayList<Object> getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(ArrayList<Object> courseInfo) {
        this.courseInfo = courseInfo;
    }
}
