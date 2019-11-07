package edu.bitcs.rate_my_professor.dtos.request_body;

public class SignUpRequestBody {
    private String uEmail;
    private String uPassword;
    private String uFirstName;
    private String uLastName;

    public SignUpRequestBody() {
    }

    public SignUpRequestBody(String uEmail, String uPassword, String uFirstName, String uLastName) {
        this.uEmail = uEmail;
        this.uPassword = uPassword;
        this.uFirstName = uFirstName;
        this.uLastName = uLastName;
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
