package edu.bitcs.rate_my_professor.services;

import edu.bitcs.rate_my_professor.daos.CourseDao;
import edu.bitcs.rate_my_professor.dtos.response_body.CourseInfo;
import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.pos.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public ResponseBody getCourseInfoBypId(String pId) {
        ResponseBody responseBody;

        if(pId == null){
            responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
        }else{
            Long id = IdHelper.getIdFromStringId(pId);

            if(id==null){
                responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
            }else {
                ArrayList<Course> courses = courseDao.getCoursesBypId(id);

                if (courses == null) {
                    responseBody = new ResponseBody(ResponseBody.GET_COURSE_ERROR, "数据库错误", null);
                } else {
                    responseBody = new ResponseBody(ResponseBody.SUCCESS, "成功", new CourseInfo(courses));
                }
            }
        }

        return responseBody;
    }
}
