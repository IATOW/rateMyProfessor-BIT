package edu.bitcs.rate_my_professor.dtos.request_body;

import java.util.ArrayList;

public class PostProfessorTagsRequestBody {
    private String rProfessor;
    private ArrayList<String> rTags;

    public PostProfessorTagsRequestBody() {
    }

    public PostProfessorTagsRequestBody(String rProfessor, ArrayList<String> rTags) {
        this.rProfessor = rProfessor;
        this.rTags = rTags;
    }

    public String getrProfessor() {
        return rProfessor;
    }

    public void setrProfessor(String rProfessor) {
        this.rProfessor = rProfessor;
    }

    public ArrayList<String> getrTags() {
        return rTags;
    }

    public void setrTags(ArrayList<String> rTags) {
        this.rTags = rTags;
    }
}
