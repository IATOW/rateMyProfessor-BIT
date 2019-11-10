package edu.bitcs.rate_my_professor.controllers;

import edu.bitcs.rate_my_professor.dtos.request_body.PostProfessorTagsRequestBody;
import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagsController {
    @Autowired
    private TagService tagService;

    @GetMapping("")
    public ResponseBody getTagsBypId(@RequestParam("pId")String pId){
        if(pId==null){
            return tagService.getTags();
        }else{
            return tagService.getTagsBypId(pId);
        }
    }

    @PostMapping("")
    public ResponseBody postRatingTags(@RequestBody PostProfessorTagsRequestBody postProfessorTagsRequestBody){
        return tagService.postProfessorTags(postProfessorTagsRequestBody);
    }
}
