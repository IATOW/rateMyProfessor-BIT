package edu.bitcs.rate_my_professor.pos;

public class School {
    private long sId;
    private String sName;
    private String sNickName;
    private String sCountry;
    private String sState;
    private String sCity;
    private String sWebsite;

    public School() {
    }

    public School(long sId, String sName, String sNickName, String sCountry, String sState, String sCity, String sWebsite) {
        this.sId = sId;
        this.sName = sName;
        this.sNickName = sNickName;
        this.sCountry = sCountry;
        this.sState = sState;
        this.sCity = sCity;
        this.sWebsite = sWebsite;
    }

    public long getsId() {
        return sId;
    }

    public void setsId(long sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsNickName() {
        return sNickName;
    }

    public void setsNickName(String sNickName) {
        this.sNickName = sNickName;
    }

    public String getsCountry() {
        return sCountry;
    }

    public void setsCountry(String sCountry) {
        this.sCountry = sCountry;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }

    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    public String getsWebsite() {
        return sWebsite;
    }

    public void setsWebsite(String sWebsite) {
        this.sWebsite = sWebsite;
    }
}
