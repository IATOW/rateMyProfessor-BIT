package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.pos.User;

//todo refactor
public class UserInfo {
    private Object userInfo;

    public UserInfo() {
    }

    public UserInfo(User user) {
        class UserInfoData{
            private String uFirstName;
            private String uLastName;
            private String uEmail;

            public UserInfoData() {
            }

            public UserInfoData(String uFirstName, String uLastName, String uEmail) {
                this.uFirstName = uFirstName;
                this.uLastName = uLastName;
                this.uEmail = uEmail;
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

            public String getuEmail() {
                return uEmail;
            }

            public void setuEmail(String uEmail) {
                this.uEmail = uEmail;
            }
        }

        this.userInfo = new UserInfoData(user.getuFirstName(),user.getuLastName(),user.getuEmail());
    }

    public UserInfo(Object userInfo) {
        this.userInfo = userInfo;
    }

    public Object getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Object userInfo) {
        this.userInfo = userInfo;
    }
}
