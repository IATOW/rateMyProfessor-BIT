package edu.bitcs.rate_my_professor.controllers;

import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

//@CrossOrigin
@CrossOrigin(allowCredentials = "true", maxAge = 0, origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public ResponseBody getCourseInfoBypId(@RequestParam String pId){
        return courseService.getCourseInfoBypId(pId);
    }
}
