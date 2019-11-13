package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolDaoImpl implements SchoolDao{
    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public School getSchoolBysId(long sId) {
        return schoolMapper.getSchoolBysId(sId);
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
