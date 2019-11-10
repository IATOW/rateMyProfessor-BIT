package edu.bitcs.rate_my_professor.services;

public class IdHelper {
    private final static Hashids hashids = new Hashids("salt of Yicheng");

    private IdHelper() {
    }

    public static Long getIdFromStringId(String id){
        long [] ids = hashids.decode(id);

        if(ids==null||ids.length==0){
            return null;
        }else{
            return ids[0];
        }

    }

    public static String getStringIdFromId(long id){
        return hashids.encode(id,1999,05,07);
    }
}
