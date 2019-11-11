package edu.bitcs.rate_my_professor.dtos.response_body;

public class ResponseBody {
    public static final int SUCCESS = 0;

    public static final int INVALID_EMAIL = 1000;
    public static final int WRONG_PASSWORD = 1001;
    public static final int WRONG_PARAMS= 1002;
    public static final int EMAIL_EXISTED = 1003;


    public static final int INVALID_SESSION = 2000;
    public static final int CREATE_USER_ERROR = 2001;
    public static final int GET_USER_ERROR = 2002;
    public static final int UPDATE_USER_ERROR = 2003;
    public static final int DELETE_USER_ERROR = 2004;

    public static final int GET_PROFESSOR_ERROR= 3000;

    public static final int GET_COURSE_ERROR = 4000;

    public static final int GET_RATING_ERROR = 5000;
    public static final int CREATE_RATING_ERROR = 5001;
    public static final int UPDATE_RATING_ERROR = 5002;

    public static final int GET_TAGS_ERROR = 6000;
    public static final int CREATE_TAGS_ERROR = 60001;

    private int code;
    private String msg;
    private Object data;

    public ResponseBody() {
    }

    public ResponseBody(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
