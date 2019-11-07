package edu.bitcs.rate_my_professor.services;

public class IdHelper {
    private final static Hashids hashids = new Hashids("salt of Yicheng");

    private IdHelper() {
    }

    public static long getIdFromStringId(String id){
        return hashids.decode(id)[0];
    }

    public static String getStringIdFromId(long id){
        return hashids.encode(id,1999,05,07);
    }
}
