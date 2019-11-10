package edu.bitcs.rate_my_professor.services;

import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.dtos.request_body.DeleteAccountRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.EditInfoRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.LogInRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.SignUpRequestBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface UserService {
    ResponseBody logIn(LogInRequestBody logInRequestBody, HttpServletRequest httpServletRequest);
    ResponseBody logOut(HttpSession httpSession);
    ResponseBody signUp(SignUpRequestBody signUpRequestBody);
    ResponseBody getUserInfo(HttpSession httpSession);
    ResponseBody editInfo(EditInfoRequestBody editInfoRequestBody,HttpSession httpSession);
    ResponseBody deleteAccount(DeleteAccountRequestBody deleteAccountRequestBody,HttpSession httpSession);
}
