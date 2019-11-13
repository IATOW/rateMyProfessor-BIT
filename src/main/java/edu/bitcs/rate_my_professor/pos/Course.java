package edu.bitcs.rate_my_professor.pos;

public class Course {
    private long cId;
    private String cName;

    public Course() {
    }

    public Course(long cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
