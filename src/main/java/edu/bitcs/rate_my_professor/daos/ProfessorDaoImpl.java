package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Department;
import edu.bitcs.rate_my_professor.pos.Professor;
import edu.bitcs.rate_my_professor.pos.School;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProfessorDaoImpl implements ProfessorDao {
    @Override
    public Professor getProfessorBypId(long pId) {
        return null;
    }

    @Override
    public Map<String, Object> getProfessorAndRelatedDepartmentAndSchoolBypId(long pId) {
        Map<String,Object> map = new HashMap<>();

        map.put("professor", new Professor(1,"yicheng","chen",1,1,4.8,0.84,3.2));
        map.put("department", new Department(1,"math...",1));
        map.put("school",new School(1,"beijing ins...","BIT","china","beijing","beijing","www..."));

        return map;
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
