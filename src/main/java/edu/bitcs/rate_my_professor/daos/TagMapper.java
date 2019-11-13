package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface TagMapper {
    @Select("select * from Tag order by tNumber desc")
    List<Tag> getTags();

    @Select("select ProfessorsHasTags.pId, ProfessorsHasTags.tId, ProfessorsHasTags.ptNumber, Tag.tId, Tag.tName from ProfessorsHasTags, Tag where ProfessorsHasTags.pId = #{pId} and ProfessorsHasTags.tId = Tag.tId")
    List<Map<String,Object>> getTagsBypId(long pId);

    @Select("call insertTagBypId(#{pId},#{tId})")
    void insertTagBypId(long pId,long tId);

}
