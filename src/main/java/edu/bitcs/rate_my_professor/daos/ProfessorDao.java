package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Professor;

import java.util.Map;

public interface ProfessorDao extends Dao {
    Professor getProfessorBypId(long pId);
    Map<String,Object> getProfessorAndRelatedDepartmentAndSchool(long pId);

}
