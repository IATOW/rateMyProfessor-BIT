package edu.bitcs.rate_my_professor.dtos.request_body;

public class EditInfoRequestBody {
    private String uFirstName;
    private String uLastName;
    private String uNewEmail;
    private String uNewPassword;
    private String uPassword;

    public EditInfoRequestBody() {
    }

    public EditInfoRequestBody(String uFirstName, String uLastName, String uNewEmail, String uNewPassword, String uPassword) {
        this.uFirstName = uFirstName;
        this.uLastName = uLastName;
        this.uNewEmail = uNewEmail;
        this.uNewPassword = uNewPassword;
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

    public String getuNewEmail() {
        return uNewEmail;
    }

    public void setuNewEmail(String uNewEmail) {
        this.uNewEmail = uNewEmail;
    }

    public String getuNewPassword() {
        return uNewPassword;
    }

    public void setuNewPassword(String uNewPassword) {
        this.uNewPassword = uNewPassword;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
}
