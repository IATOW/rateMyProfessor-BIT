package edu.bitcs.rate_my_professor.dtos.response_body;

import java.util.ArrayList;
import java.util.List;

public class RatingInfoData {
    private String rDate;
    private double rQuality;
    private double rDifficulty;
    private String rClass;
    private boolean rAttendance;
    private boolean rTakeAgain;
    private String rGradeReceived;
    private String rComment;
    private int rPeopleFoundUseful;
    private int rPeopleDidNotFoundUseful;
    private List<String> rTags;

    public RatingInfoData() {
    }

    public RatingInfoData(String rDate, double rQuality, double rDifficulty, String rClass, boolean rAttendance, boolean rTakeAgain, String rGradeReceived, String rComment, int rPeopleFoundUseful, int rPeopleDidNotFoundUseful, List<String> rTags) {
        this.rDate = rDate;
        this.rQuality = rQuality;
        this.rDifficulty = rDifficulty;
        this.rClass = rClass;
        this.rAttendance = rAttendance;
        this.rTakeAgain = rTakeAgain;
        this.rGradeReceived = rGradeReceived;
        this.rComment = rComment;
        this.rPeopleFoundUseful = rPeopleFoundUseful;
        this.rPeopleDidNotFoundUseful = rPeopleDidNotFoundUseful;
        this.rTags = rTags;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public double getrQuality() {
        return rQuality;
    }

    public void setrQuality(double rQuality) {
        this.rQuality = rQuality;
    }

    public double getrDifficulty() {
        return rDifficulty;
    }

    public void setrDifficulty(double rDifficulty) {
        this.rDifficulty = rDifficulty;
    }

    public String getrClass() {
        return rClass;
    }

    public void setrClass(String rClass) {
        this.rClass = rClass;
    }

    public boolean isrAttendance() {
        return rAttendance;
    }

    public void setrAttendance(boolean rAttendance) {
        this.rAttendance = rAttendance;
    }

    public boolean isrTakeAgain() {
        return rTakeAgain;
    }

    public void setrTakeAgain(boolean rTakeAgain) {
        this.rTakeAgain = rTakeAgain;
    }

    public String getrGradeReceived() {
        return rGradeReceived;
    }

    public void setrGradeReceived(String rGradeReceived) {
        this.rGradeReceived = rGradeReceived;
    }

    public String getrComment() {
        return rComment;
    }

    public void setrComment(String rComment) {
        this.rComment = rComment;
    }

    public int getrPeopleFoundUseful() {
        return rPeopleFoundUseful;
    }

    public void setrPeopleFoundUseful(int rPeopleFoundUseful) {
        this.rPeopleFoundUseful = rPeopleFoundUseful;
    }

    public int getrPeopleDidNotFoundUseful() {
        return rPeopleDidNotFoundUseful;
    }

    public void setrPeopleDidNotFoundUseful(int rPeopleDidNotFoundUseful) {
        this.rPeopleDidNotFoundUseful = rPeopleDidNotFoundUseful;
    }

    public List<String> getrTags() {
        return rTags;
    }

    public void setrTags(List<String> rTags) {
        this.rTags = rTags;
    }
}
