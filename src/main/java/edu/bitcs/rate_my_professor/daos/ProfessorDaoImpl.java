package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Department;
import edu.bitcs.rate_my_professor.pos.Professor;
import edu.bitcs.rate_my_professor.pos.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProfessorDaoImpl implements ProfessorDao {
    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public Professor getProfessorBypId(long pId) {
        return professorMapper.getProfessorBypId(pId);
    }

    @Override
    public Map<String, Object> getProfessorAndRelatedDepartmentAndSchoolBypId(long pId) {
        Map<String,Object> map = professorMapper.getProfessorAndRelatedDepartmentAndSchoolBypId(pId);

        Professor professor = new Professor((long)map.get("pId"),(String)map.get("pFirstName"),(String)map.get("pLastName"),
                (long)map.get("dId"),(long)map.get("sId"),(double)map.get("pOverallQuality"),
                (double)map.get("pWouldTakeAgain"), (double)map.get("pLevelOfDifficulty"));

        Department department = new Department((long)map.get("dId"),(String)map.get("dName"),(long)map.get("sId"));

        School school = new School((long)map.get("sId"),(String)map.get("sName"),(String)map.get("sNickName"),
                (String)map.get("sCountry"),(String)map.get("sState"),(String)map.get("sCity"),(String)map.get("sWebsite"));

        map.put("professor", professor);
        map.put("department",department);
        map.put("school", school);

        return map;
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
