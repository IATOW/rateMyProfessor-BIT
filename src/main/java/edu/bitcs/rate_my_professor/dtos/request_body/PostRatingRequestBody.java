package edu.bitcs.rate_my_professor.dtos.request_body;

import java.util.ArrayList;

public class PostRatingRequestBody {
    private String rCourse;
    private float rQuality;
    private float rDifficulty;
    private boolean rTakeAgain;
    private boolean rAttendance;
    private String rGradeReceived;
    private ArrayList<Integer> rTags;
    private String rComment;

    public PostRatingRequestBody() {
    }

    public PostRatingRequestBody(String rCourse, float rQuality, float rDifficulty, boolean rTakeAgain,
                                 boolean rAttendance, String rGradeReceived, ArrayList<Integer> rTags,
                                 String rComment) {
        this.rCourse = rCourse;
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

    public float getrQuality() {
        return rQuality;
    }

    public void setrQuality(float rQuality) {
        this.rQuality = rQuality;
    }

    public float getrDifficulty() {
        return rDifficulty;
    }

    public void setrDifficulty(float rDifficulty) {
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

    public ArrayList<Integer> getrTags() {
        return rTags;
    }

    public void setrTags(ArrayList<Integer> rTags) {
        this.rTags = rTags;
    }

    public String getrComment() {
        return rComment;
    }

    public void setrComment(String rComment) {
        this.rComment = rComment;
    }
}
