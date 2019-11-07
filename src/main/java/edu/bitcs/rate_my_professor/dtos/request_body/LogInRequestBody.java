package edu.bitcs.rate_my_professor.dtos.request_body;

public class LogInRequestBody {
    private String uEmail;
    private String uPassword;

    public LogInRequestBody() {
    }

    public LogInRequestBody(String uEmail, String uPassword) {
        this.uEmail = uEmail;
        this.uPassword = uPassword;
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

    @Override
    public String toString() {
        return "LogInRequestBody{" +
                "uEmail='" + uEmail + '\'' +
                ", uPassword='" + uPassword + '\'' +
                '}';
    }
}
