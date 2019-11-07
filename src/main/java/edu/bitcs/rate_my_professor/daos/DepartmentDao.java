package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.Department;

public interface DepartmentDao extends Dao {
    Department getDepartmentBydId(long dId);
}
