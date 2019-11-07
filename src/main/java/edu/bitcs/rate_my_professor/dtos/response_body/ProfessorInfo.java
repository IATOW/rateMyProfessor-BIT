package edu.bitcs.rate_my_professor.dtos.response_body;

import edu.bitcs.rate_my_professor.services.Hashids;
import edu.bitcs.rate_my_professor.pos.Department;
import edu.bitcs.rate_my_professor.pos.Professor;
import edu.bitcs.rate_my_professor.pos.School;
import edu.bitcs.rate_my_professor.services.IdHelper;

import java.util.ArrayList;

public class ProfessorInfo {
    private Object professorInfo;
    private ArrayList<Link> links;

    public ProfessorInfo() {
    }

    public ProfessorInfo(Professor professor, Department department, School school){
        class ProfessorInfoData{
            private String pFirstName;
            private String pLastName;
            private String pDepartment;
            private String pSchoolName;
            private String pSchoolWebsite;
            private String pSchoolState;
            private String pSchoolCity;
            private double pOverAllQuality;
            private String pWouldTakeAgain;
            private double pLevelOfDifficulty;

            public ProfessorInfoData() {
            }

            public ProfessorInfoData(String pFirstName, String pLastName, String pDepartment, String pSchoolName, String pSchoolWebsite, String pSchoolState, String pSchoolCity, double pOverAllQuality, String pWouldTakeAgain, double pLevelOfDifficulty) {
                this.pFirstName = pFirstName;
                this.pLastName = pLastName;
                this.pDepartment = pDepartment;
                this.pSchoolName = pSchoolName;
                this.pSchoolWebsite = pSchoolWebsite;
                this.pSchoolState = pSchoolState;
                this.pSchoolCity = pSchoolCity;
                this.pOverAllQuality = pOverAllQuality;
                this.pWouldTakeAgain = pWouldTakeAgain;
                this.pLevelOfDifficulty = pLevelOfDifficulty;
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

            public String getpDepartment() {
                return pDepartment;
            }

            public void setpDepartment(String pDepartment) {
                this.pDepartment = pDepartment;
            }

            public String getpSchoolName() {
                return pSchoolName;
            }

            public void setpSchoolName(String pSchoolName) {
                this.pSchoolName = pSchoolName;
            }

            public String getpSchoolWebsite() {
                return pSchoolWebsite;
            }

            public void setpSchoolWebsite(String pSchoolWebsite) {
                this.pSchoolWebsite = pSchoolWebsite;
            }

            public String getpSchoolState() {
                return pSchoolState;
            }

            public void setpSchoolState(String pSchoolState) {
                this.pSchoolState = pSchoolState;
            }

            public String getpSchoolCity() {
                return pSchoolCity;
            }

            public void setpSchoolCity(String pSchoolCity) {
                this.pSchoolCity = pSchoolCity;
            }

            public double getpOverAllQuality() {
                return pOverAllQuality;
            }

            public void setpOverAllQuality(double pOverAllQuality) {
                this.pOverAllQuality = pOverAllQuality;
            }

            public String getpWouldTakeAgain() {
                return pWouldTakeAgain;
            }

            public void setpWouldTakeAgain(String pWouldTakeAgain) {
                this.pWouldTakeAgain = pWouldTakeAgain;
            }

            public double getpLevelOfDifficulty() {
                return pLevelOfDifficulty;
            }

            public void setpLevelOfDifficulty(double pLevelOfDifficulty) {
                this.pLevelOfDifficulty = pLevelOfDifficulty;
            }
        }

        ProfessorInfoData professorInfoData = new ProfessorInfoData();

        professorInfoData.setpFirstName(professor.getpFirstName());
        professorInfoData.setpLastName(professor.getpLastName());
        professorInfoData.setpDepartment(department.getdName());
        professorInfoData.setpSchoolName(school.getsName());
        professorInfoData.setpSchoolWebsite(school.getsWebsite());
        professorInfoData.setpSchoolState(school.getsState());
        professorInfoData.setpSchoolCity(school.getsCity());
        professorInfoData.setpOverAllQuality(professor.getpOverAllQuality());
        professorInfoData.setpWouldTakeAgain(professor.getPWouldTakeAgain()*100+"%");
        professorInfoData.setpLevelOfDifficulty(professor.getpLevelOfDifficulty());

        this.professorInfo = professorInfoData;

        ArrayList<Link> links = new ArrayList<>();

        String pId = IdHelper.getStringIdFromId(professor.getpId());

        links.add(new Link("pTags","/tags?pId="+pId));
        links.add(new Link("pCourses","/courses?pId="+pId));
        links.add(new Link("pRatings","/ratings?pId="+pId+"&offset="+0+"&limit="+0));

        this.links = links;

    }

    public ProfessorInfo(Object professorInfo, ArrayList<Link> links) {
        this.professorInfo = professorInfo;
        this.links = links;
    }

    public Object getProfessorInfo() {
        return professorInfo;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }
}
