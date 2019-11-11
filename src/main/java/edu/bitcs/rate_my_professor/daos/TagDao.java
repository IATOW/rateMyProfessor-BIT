package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Tag;

import java.util.ArrayList;
import java.util.Map;

public interface TagDao extends Dao {
    ArrayList<Tag> getTags();
    Map<String,Object> getTagsBypId(long pId);

    boolean insertTagsBypId(ArrayList<Tag> tags,long pId);
}
