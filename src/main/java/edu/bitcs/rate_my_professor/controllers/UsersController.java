package edu.bitcs.rate_my_professor.controllers;

import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.dtos.request_body.DeleteAccountRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.EditInfoRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.SignUpRequestBody;
import edu.bitcs.rate_my_professor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

//@CrossOrigin(allowCredentials = "true")
@CrossOrigin(allowCredentials = "true", maxAge = 0, origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseBody signUp(@RequestBody SignUpRequestBody signUpRequestBody){
        return userService.signUp(signUpRequestBody);
    }

    @GetMapping("")
    public ResponseBody getUserInfo(HttpServletRequest httpServletRequest){
        return userService.getUserInfo(httpServletRequest.getSession(false));
    }

    @PatchMapping("")
    public ResponseBody editInfo(HttpServletRequest httpServletRequest,@RequestBody EditInfoRequestBody editInfoRequestBody){
        return userService.editInfo(editInfoRequestBody,httpServletRequest.getSession(false));
    }

    @DeleteMapping("")
    public ResponseBody deleteAccount(HttpServletRequest httpServletRequest,
                                      @RequestBody DeleteAccountRequestBody deleteAccountRequestBody){
        return userService.deleteAccount(deleteAccountRequestBody,httpServletRequest.getSession(false));
    }
}
