package edu.bitcs.rate_my_professor.services;

import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;

public interface ProfessorService {
    ResponseBody getProfessorInfoBypId(String pId);
}
