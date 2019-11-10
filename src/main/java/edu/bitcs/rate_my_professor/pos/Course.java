package edu.bitcs.rate_my_professor.pos;

public class Course {
    private long cId;
    private String name;

    public Course() {
    }

    public Course(long cId, String name) {
        this.cId = cId;
        this.name = name;
    }

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
