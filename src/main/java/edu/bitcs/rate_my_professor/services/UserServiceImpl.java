package edu.bitcs.rate_my_professor.services;

import edu.bitcs.rate_my_professor.daos.UserDao;
import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.dtos.request_body.DeleteAccountRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.EditInfoRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.LogInRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.SignUpRequestBody;
import edu.bitcs.rate_my_professor.dtos.response_body.UserInfo;
import edu.bitcs.rate_my_professor.pos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{
    public final static String LOG_IN_REQUEST_BODY = "logInRequestBody";

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseBody logIn(LogInRequestBody logInRequestBody, HttpServletRequest httpServletRequest) {
        ResponseBody responseBody;

        String uEmail = logInRequestBody.getuEmail();
        String uPassword = logInRequestBody.getuPassword();

        if(userDao.isEmailExisted(uEmail)){
            if(userDao.isPasswordCorrect(uEmail,uPassword)){
                HttpSession httpSession = httpServletRequest.getSession();
                httpSession.setAttribute(LOG_IN_REQUEST_BODY,logInRequestBody);

                responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",null);
            }else{
                responseBody = new ResponseBody(ResponseBody.WRONG_PASSWORD,"错误的密码",null);
            }
        }else{
            responseBody = new ResponseBody(ResponseBody.INVALID_EMAIL,"错误的邮箱",null);
        }

        return responseBody;
    }

    @Override
    public ResponseBody logOut(HttpSession httpSession) {
        ResponseBody responseBody;

        if(httpSession==null){
            responseBody = new ResponseBody(ResponseBody.INVALID_SESSION,"无效的会话",null);
        }else{
            httpSession.invalidate();
            responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",null);
        }

        return responseBody;
    }

    @Override
    public ResponseBody signUp(SignUpRequestBody signUpRequestBody) {
        ResponseBody responseBody;

        if(userDao.isEmailExisted(signUpRequestBody.getuEmail())){
            responseBody = new ResponseBody(ResponseBody.EMAIL_EXISTED,"重复的邮箱",null);
        }else{
            if(userDao.insertUser(new User(signUpRequestBody))){
                responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",null);
            }else{
                responseBody = new ResponseBody(ResponseBody.CREATE_USER_ERROR,"数据库错误",null);
            }
        }
        return responseBody;
    }

    @Override
    public ResponseBody getUserInfo(HttpSession httpSession) {
        ResponseBody responseBody;

        if(httpSession==null||httpSession.getAttribute(LOG_IN_REQUEST_BODY)==null){
            responseBody = new ResponseBody(ResponseBody.INVALID_SESSION,"无效的会话",null);
        }else{
            LogInRequestBody logInRequestBody = (LogInRequestBody)httpSession.getAttribute(LOG_IN_REQUEST_BODY);
            User user = userDao.getUser(logInRequestBody.getuEmail());
            if(user!=null){
                responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",new UserInfo(user));
            }else {
                responseBody = new ResponseBody(ResponseBody.GET_USER_ERROR,"数据库错误",null);
            }
        }

        return responseBody;
    }


    @Override
    public ResponseBody editInfo(EditInfoRequestBody editInfoRequestBody,HttpSession httpSession) {
        ResponseBody responseBody;

        if(httpSession==null||httpSession.getAttribute(LOG_IN_REQUEST_BODY)==null){
            responseBody = new ResponseBody(ResponseBody.INVALID_SESSION,"无效的会话",null);
        }else{
            LogInRequestBody logInRequestBody = (LogInRequestBody)httpSession.getAttribute(LOG_IN_REQUEST_BODY);
            if(logInRequestBody.getuPassword().equals(editInfoRequestBody.getuPassword())){
                if(userDao.updateUserByuEmail(new User(editInfoRequestBody),logInRequestBody.getuEmail())){
                    responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",null);
                }else{
                    responseBody = new ResponseBody(ResponseBody.UPDATE_USER_ERROR,"数据库错误",null);
                }
            }else{
                responseBody = new ResponseBody(ResponseBody.INVALID_SESSION,"无效的会话",null);
            }
        }

        return responseBody;
    }

    @Override
    public ResponseBody deleteAccount(DeleteAccountRequestBody deleteAccountRequestBody,HttpSession httpSession) {
        ResponseBody responseBody;

        if(httpSession==null||httpSession.getAttribute(LOG_IN_REQUEST_BODY)==null){
            responseBody = new ResponseBody(ResponseBody.INVALID_SESSION,"无效的会话",null);
        }else{
            LogInRequestBody logInRequestBody = (LogInRequestBody)httpSession.getAttribute(LOG_IN_REQUEST_BODY);
            if(logInRequestBody.getuPassword().equals(deleteAccountRequestBody.getuPassword())){
                if(userDao.deleteUserByuEmail(logInRequestBody.getuEmail())){
                    responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",null);
                }else {
                    responseBody = new ResponseBody(ResponseBody.DELETE_USER_ERROR, "数据库错误", null);
                }
            }else{
                responseBody = new ResponseBody(ResponseBody.INVALID_SESSION,"无效的会话",null);
            }
        }

        return responseBody;
    }

}
