package edu.bitcs.rate_my_professor.pos;

import edu.bitcs.rate_my_professor.dtos.request_body.EditInfoRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.SignUpRequestBody;

public class User {
    long rId;
    String uEmail;
    String uPassword;
    String uFirstName;
    String uLastName;

    public User() {
    }

    public User(String uEmail, String uPassword, String uFirstName, String uLastName) {
        this.uEmail = uEmail;
        this.uPassword = uPassword;
        this.uFirstName = uFirstName;
        this.uLastName = uLastName;
    }

    public User(SignUpRequestBody signUpRequestBody){
        this.uEmail = signUpRequestBody.getuEmail();
        this.uPassword = signUpRequestBody.getuPassword();
        this.uFirstName = signUpRequestBody.getuFirstName();
        this.uLastName = signUpRequestBody.getuLastName();
    }

    public User(EditInfoRequestBody editInfoRequestBody){
        this.uEmail = editInfoRequestBody.getuNewEmail();
        this.uPassword = editInfoRequestBody.getuNewPassword();
        this.uFirstName = editInfoRequestBody.getuFirstName();
        this.uLastName = editInfoRequestBody.getuLastName();
    }

    public User(long rId, String uEmail, String uPassword, String uFirstName, String uLastName) {
        this.rId = rId;
        this.uEmail = uEmail;
        this.uPassword = uPassword;
        this.uFirstName = uFirstName;
        this.uLastName = uLastName;
    }

    public long getrId() {
        return rId;
    }

    public void setrId(long rId) {
        this.rId = rId;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuFirstName() {
        return uFirstName;
    }

    public void setuFirstName(String uFirstName) {
        this.uFirstName = uFirstName;
    }

    public String getuLastName() {
        return uLastName;
    }

    public void setuLastName(String uLastName) {
        this.uLastName = uLastName;
    }
}
