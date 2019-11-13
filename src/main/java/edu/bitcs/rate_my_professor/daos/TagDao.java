package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface TagDao extends Dao {
    List<Tag> getTags();
    Map<String,Object> getTagsBypId(long pId);

    boolean insertTagsBypId(List<Tag> tags,long pId);
}
