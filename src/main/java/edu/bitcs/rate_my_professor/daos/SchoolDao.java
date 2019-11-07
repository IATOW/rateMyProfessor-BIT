package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.School;

public interface SchoolDao extends Dao {
    School getSchoolBysId(long sId);
}
