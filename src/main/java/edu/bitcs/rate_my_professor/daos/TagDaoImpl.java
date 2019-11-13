package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TagDaoImpl implements TagDao {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> getTags() {
        return tagMapper.getTags();
    }

    @Override
    public Map<String, Object> getTagsBypId(long pId) {

        List<Tag> tags = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        List<Map<String,Object>> list = tagMapper.getTagsBypId(pId);

        for(Map<String,Object> map : list){
            Tag tag = new Tag((long)map.get("tId"),(String)map.get("tName"));
            tags.add(tag);

            numbers.add((int)map.get("ptNumber"));
        }

        Map<String,Object> map = new HashMap<>();

        map.put("tags", tags);
        map.put("numbers", numbers);

        return map;
    }

    @Override
    public boolean insertTagsBypId(List<Tag> tags, long pId) {
        for(Tag tag:tags){
            if(tagMapper.insertTagBypId(tag.gettId(), pId)==0){
                return false;
            }
        }

        return true;
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
