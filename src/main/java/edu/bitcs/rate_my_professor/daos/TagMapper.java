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
    @Select("select * from Tag")
    List<Tag> getTags();

    @Select("select ProfessorsHasTags.pId, ProfessorsHasTags.tId, ProfessorsHasTags.number, Tag.tId, Tag.tName from ProfessorsHasTags, Tag where ProfessorsHasTags.pId = #{pId} and ProfessorsHasTags.tId = Tag.tId")
    List<Map<String,Object>> getTagsBypId(long pId);

    @Update("update ProfessorsHasTags set number = number+1 where pId = #{pId} and tId = #{tId}")
    long insertTagBypId(long tId,long pId);

}
