package edu.bitcs.rate_my_professor.services;

import edu.bitcs.rate_my_professor.dtos.request_body.PostProfessorTagsRequestBody;
import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;

public interface TagService {
    ResponseBody getTags();
    ResponseBody getTagsBypId(String pId);

    ResponseBody postProfessorTags(PostProfessorTagsRequestBody postProfessorTagsRequestBody);
}
