package edu.bitcs.rate_my_professor.dtos.request_body;

import java.util.ArrayList;

public class PostRatingRequestBody {
    private String rCourse;
    private String rProfessor;
    private double rQuality;
    private double rDifficulty;
    private boolean rTakeAgain;
    private boolean rAttendance;
    private String rGradeReceived;
    private ArrayList<String> rTags;
    private String rComment;

    public PostRatingRequestBody() {
    }

    public PostRatingRequestBody(String rCourse, String rProfessor, double rQuality, double rDifficulty, boolean rTakeAgain, boolean rAttendance, String rGradeReceived, ArrayList<String> rTags, String rComment) {
        this.rCourse = rCourse;
        this.rProfessor = rProfessor;
        this.rQuality = rQuality;
        this.rDifficulty = rDifficulty;
        this.rTakeAgain = rTakeAgain;
        this.rAttendance = rAttendance;
        this.rGradeReceived = rGradeReceived;
        this.rTags = rTags;
        this.rComment = rComment;
    }

    public String getrCourse() {
        return rCourse;
    }

    public void setrCourse(String rCourse) {
        this.rCourse = rCourse;
    }

    public String getrProfessor() {
        return rProfessor;
    }

    public void setrProfessor(String rProfessor) {
        this.rProfessor = rProfessor;
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

    public boolean isrTakeAgain() {
        return rTakeAgain;
    }

    public void setrTakeAgain(boolean rTakeAgain) {
        this.rTakeAgain = rTakeAgain;
    }

    public boolean isrAttendance() {
        return rAttendance;
    }

    public void setrAttendance(boolean rAttendance) {
        this.rAttendance = rAttendance;
    }

    public String getrGradeReceived() {
        return rGradeReceived;
    }

    public void setrGradeReceived(String rGradeReceived) {
        this.rGradeReceived = rGradeReceived;
    }

    public ArrayList<String> getrTags() {
        return rTags;
    }

    public void setrTags(ArrayList<String> rTags) {
        this.rTags = rTags;
    }

    public String getrComment() {
        return rComment;
    }

    public void setrComment(String rComment) {
        this.rComment = rComment;
    }
}
