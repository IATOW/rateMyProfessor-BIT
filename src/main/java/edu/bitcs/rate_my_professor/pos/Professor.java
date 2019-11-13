package edu.bitcs.rate_my_professor.pos;

public class Professor {
    private long pId;
    private String pFirstName;
    private String pLastName;
    private long pDepartment;
    private long pSchool;
    private double pOverallQuality;
    private double pWouldTakeAgain;
    private double pLevelOfDifficulty;

    public Professor() {
    }

    public Professor(long pId, String pFirstName, String pLastName, long pDepartment, long pSchool, double pOverallQuality, double pWouldTakeAgain, double pLevelOfDifficulty) {
        this.pId = pId;
        this.pFirstName = pFirstName;
        this.pLastName = pLastName;
        this.pDepartment = pDepartment;
        this.pSchool = pSchool;
        this.pOverallQuality = pOverallQuality;
        this.pWouldTakeAgain = pWouldTakeAgain;
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

    public double getpOverallQuality() {
        return pOverallQuality;
    }

    public void setpOverallQuality(double pOverallQuality) {
        this.pOverallQuality = pOverallQuality;
    }

    public double getpWouldTakeAgain() {
        return pWouldTakeAgain;
    }

    public void setpWouldTakeAgain(double pWouldTakeAgain) {
        this.pWouldTakeAgain = pWouldTakeAgain;
    }

    public double getpLevelOfDifficulty() {
        return pLevelOfDifficulty;
    }

    public void setpLevelOfDifficulty(double pLevelOfDifficulty) {
        this.pLevelOfDifficulty = pLevelOfDifficulty;
    }
}
