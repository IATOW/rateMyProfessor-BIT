package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SchoolMapper {
    @Select("select * from School where sId = #{sId}")
    School getSchoolBysId(long sId);
}
