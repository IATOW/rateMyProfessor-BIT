package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Tag;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class TagDaoImpl implements TagDao {
    @Override
    public ArrayList<Tag> getTags() {
        return null;
    }

    @Override
    public Map<String, Object> getTagsBypId(long pId) {
        return null;
    }

    @Override
    public boolean insertTagsBypId(ArrayList<Tag> tags, long pId) {
        return false;
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
