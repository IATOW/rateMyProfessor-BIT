package edu.bitcs.rate_my_professor.pos;

public class Department {
    private long dId;
    private String dName;
    private long dSchool;

    public Department() {
    }

    public Department(long dId, String dName, long dSchool) {
        this.dId = dId;
        this.dName = dName;
        this.dSchool = dSchool;
    }

    public long getdId() {
        return dId;
    }

    public void setdId(long dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public long getdSchool() {
        return dSchool;
    }

    public void setdSchool(long dSchool) {
        this.dSchool = dSchool;
    }
}
