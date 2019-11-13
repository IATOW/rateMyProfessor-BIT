package edu.bitcs.rate_my_professor.pos;

import edu.bitcs.rate_my_professor.dtos.request_body.PostRatingRequestBody;
import edu.bitcs.rate_my_professor.services.IdHelper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class Rating {
    private long rId;
    private long rCourse;
    private long rProfessor;
    private long rUser;
    private double rQuality;
    private double rDifficulty;
    private boolean rTakeAgain;
    private boolean rAttendance;
    private String rGradeReceived;
    private String rComment;
    private Date rDate;
    private int rPeopleFoundUseful;
    private int rPeopleDidNotFindUseful;

    public Rating() {
    }

    public Rating(PostRatingRequestBody postRatingRequestBody) throws NullPointerException{

        String rCourse = postRatingRequestBody.getrCourse();
        Long rCourseId = IdHelper.getIdFromStringId(rCourse);
        this.rCourse = rCourseId;

        String rProfessor = postRatingRequestBody.getrProfessor();
        Long rProfessorId = IdHelper.getIdFromStringId(rProfessor);
        this.rProfessor = rProfessorId;

        this.rQuality = postRatingRequestBody.getrQuality();
        this.rDifficulty = postRatingRequestBody.getrDifficulty();
        this.rTakeAgain = postRatingRequestBody.isrTakeAgain();
        this.rAttendance = postRatingRequestBody.isrAttendance();
        this.rGradeReceived = postRatingRequestBody.getrGradeReceived();
        this.rComment = postRatingRequestBody.getrComment();

        this.rDate = new Date(Calendar.getInstance().getTime().getTime());

        this.rPeopleFoundUseful = 0;
        this.rPeopleDidNotFindUseful = 0;
    }

    public Rating(long rId, long rCourse, long rProfessor, long rUser, double rQuality, double rDifficulty, boolean rTakeAgain, boolean rAttendance, String rGradeReceived, String rComment, Date rDate, int rPeopleFoundUseful, int rPeopleDidNotFindUseful) {
        this.rId = rId;
        this.rCourse = rCourse;
        this.rProfessor = rProfessor;
        this.rUser = rUser;
        this.rQuality = rQuality;
        this.rDifficulty = rDifficulty;
        this.rTakeAgain = rTakeAgain;
        this.rAttendance = rAttendance;
        this.rGradeReceived = rGradeReceived;
        this.rComment = rComment;
        this.rDate = rDate;
        this.rPeopleFoundUseful = rPeopleFoundUseful;
        this.rPeopleDidNotFindUseful = rPeopleDidNotFindUseful;
    }

    public long getrId() {
        return rId;
    }

    public void setrId(long rId) {
        this.rId = rId;
    }

    public long getrCourse() {
        return rCourse;
    }

    public void setrCourse(long rCourse) {
        this.rCourse = rCourse;
    }

    public long getrProfessor() {
        return rProfessor;
    }

    public void setrProfessor(long rProfessor) {
        this.rProfessor = rProfessor;
    }

    public long getrUser() {
        return rUser;
    }

    public void setrUser(long rUser) {
        this.rUser = rUser;
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

    public String getrComment() {
        return rComment;
    }

    public void setrComment(String rComment) {
        this.rComment = rComment;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public int getrPeopleFoundUseful() {
        return rPeopleFoundUseful;
    }

    public void setrPeopleFoundUseful(int rPeopleFoundUseful) {
        this.rPeopleFoundUseful = rPeopleFoundUseful;
    }

    public int getrPeopleDidNotFindUseful() {
        return rPeopleDidNotFindUseful;
    }

    public void setrPeopleDidNotFindUseful(int rPeopleDidNotFindUseful) {
        this.rPeopleDidNotFindUseful = rPeopleDidNotFindUseful;
    }
}