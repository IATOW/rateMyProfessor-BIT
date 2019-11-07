package edu.bitcs.rate_my_professor.pos;

public class Professor {
    private long pId;
    private String pFirstName;
    private String pLastName;
    private long pDepartment;
    private long pSchool;
    private double pOverAllQuality;
    private double PWouldTakeAgain;
    private double pLevelOfDifficulty;

    public Professor() {
    }

    public Professor(long pId, String pFirstName, String pLastName, long pDepartment, long pSchool, double pOverAllQuality, double PWouldTakeAgain, double pLevelOfDifficulty) {
        this.pId = pId;
        this.pFirstName = pFirstName;
        this.pLastName = pLastName;
        this.pDepartment = pDepartment;
        this.pSchool = pSchool;
        this.pOverAllQuality = pOverAllQuality;
        this.PWouldTakeAgain = PWouldTakeAgain;
        this.pLevelOfDifficulty = pLevelOfDifficulty;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public String getpFirstName() {
        return pFirstName;
    }

    public void setpFirstName(String pFirstName) {
        this.pFirstName = pFirstName;
    }

    public String getpLastName() {
        return pLastName;
    }

    public void setpLastName(String pLastName) {
        this.pLastName = pLastName;
    }

    public long getpDepartment() {
        return pDepartment;
    }

    public void setpDepartment(long pDepartment) {
        this.pDepartment = pDepartment;
    }

    public long getpSchool() {
        return pSchool;
    }

    public void setpSchool(long pSchool) {
        this.pSchool = pSchool;
    }

    public double getpOverAllQuality() {
        return pOverAllQuality;
    }

    public void setpOverAllQuality(double pOverAllQuality) {
        this.pOverAllQuality = pOverAllQuality;
    }

    public double getPWouldTakeAgain() {
        return PWouldTakeAgain;
    }

    public void setPWouldTakeAgain(double PWouldTakeAgain) {
        this.PWouldTakeAgain = PWouldTakeAgain;
    }

    public double getpLevelOfDifficulty() {
        return pLevelOfDifficulty;
    }

    public void setpLevelOfDifficulty(double pLevelOfDifficulty) {
        this.pLevelOfDifficulty = pLevelOfDifficulty;
    }
}
