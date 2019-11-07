package edu.bitcs.rate_my_professor.controllers;

import edu.bitcs.rate_my_professor.dtos.request_body.LogInRequestBody;
import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sessions")
public class SessionsController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseBody logIn(HttpServletRequest httpServletRequest, @RequestBody LogInRequestBody logInRequestBody){
        return userService.logIn(logInRequestBody,httpServletRequest);
    }

    @DeleteMapping("")
    public ResponseBody logOut(HttpServletRequest httpServletRequest){
        return userService.logOut(httpServletRequest.getSession(false));
    }
}
