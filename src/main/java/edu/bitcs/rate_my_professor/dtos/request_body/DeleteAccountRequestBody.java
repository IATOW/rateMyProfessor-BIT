package edu.bitcs.rate_my_professor.dtos.request_body;

public class DeleteAccountRequestBody {
    private String uPassword;

    public DeleteAccountRequestBody() {
    }

    public DeleteAccountRequestBody(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
}
