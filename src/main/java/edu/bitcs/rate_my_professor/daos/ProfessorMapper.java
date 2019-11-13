package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Professor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface ProfessorMapper {
    @Select("select * from Professor where pId = #{pId}")
    Professor getProfessorBypId(long pId);

    @Select("select Professor.pId,Professor.pFirstName,Professor.pLastName,Professor.pDepartment,Professor.pSchool,Professor.pOverallQuality,Professor.pWouldTakeAgain,Professor.pLevelOfDifficulty, Department.dId,Department.dName, School.sId,School.sName,School.sNickName,School.sCountry,School.sState,School.sCity,School.sWebsite from Professor,Department,School where Professor.pId = #{pId} and Professor.pDepartment = Department.dId and Professor.pSchool = School.sId")
    Map<String,Object> getProfessorAndRelatedDepartmentAndSchoolBypId(long pId);
}
