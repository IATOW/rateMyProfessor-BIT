package edu.bitcs.rate_my_professor.services;

import edu.bitcs.rate_my_professor.daos.DepartmentDao;
import edu.bitcs.rate_my_professor.daos.ProfessorDao;
import edu.bitcs.rate_my_professor.daos.SchoolDao;
import edu.bitcs.rate_my_professor.dtos.response_body.ProfessorInfo;
import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.pos.Department;
import edu.bitcs.rate_my_professor.pos.Professor;
import edu.bitcs.rate_my_professor.pos.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorDao professorDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public ResponseBody getProfessorInfoBypId(String pId) {
        ResponseBody responseBody;

        Map<String,Object> map = professorDao.getProfessorAndRelatedDepartmentAndSchool(IdHelper.getIdFromStringId(pId));

        Professor professor = (Professor) map.get("professor");
        Department department = (Department) map.get("department");
        School school = (School) map.get("school");

        if(professor==null||department==null||school==null){
            responseBody = new ResponseBody(ResponseBody.GET_USER_ERROR,"数据库错误",null);
        }else{
            responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",new ProfessorInfo(professor,department,
                    school));
        }

        return responseBody;
    }
}
