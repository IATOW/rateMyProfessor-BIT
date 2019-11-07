package edu.bitcs.rate_my_professor.controllers;

import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/{pId}")
    public ResponseBody getCourseInfoBypId(@PathVariable String pId){
        return courseService.getCourseInfoBypId(pId);
    }
}
