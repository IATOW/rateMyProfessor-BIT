package edu.bitcs.rate_my_professor.services;

import edu.bitcs.rate_my_professor.daos.TagDao;
import edu.bitcs.rate_my_professor.dtos.request_body.PostProfessorTagsRequestBody;
import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.dtos.response_body.TagInfo;
import edu.bitcs.rate_my_professor.dtos.response_body.TagInfoBypId;
import edu.bitcs.rate_my_professor.pos.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagDao tagDao;

    @Override
    public ResponseBody getTags() {
        ResponseBody responseBody;

        List<Tag> tags = tagDao.getTags();

        if(tags==null){
            responseBody = new ResponseBody(ResponseBody.GET_TAGS_ERROR,"数据库错误",null);
        }else{
            responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",new TagInfo(tags));
        }

        return responseBody;
    }

    @Override
    public ResponseBody getTagsBypId(String pId) {
        ResponseBody responseBody;

        Long id = IdHelper.getIdFromStringId(pId);

        if(id==null){
            responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
        }else{
            Map<String,Object> map = tagDao.getTagsBypId(id);

            List<Tag> tags = (List<Tag>) map.get("tags");
            List<Integer> numbers = (List<Integer>) map.get("numbers");

            if(tags==null||numbers==null){
                responseBody = new ResponseBody(ResponseBody.GET_TAGS_ERROR,"数据库错误",null);
            }else{
                responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",new TagInfoBypId(tags,numbers));
            }
        }

        return responseBody;
    }

    @Override
    public ResponseBody postProfessorTags(PostProfessorTagsRequestBody postProfessorTagsRequestBody) {
        ResponseBody responseBody;

        String rProfessor = postProfessorTagsRequestBody.getrProfessor();

        Long pId = IdHelper.getIdFromStringId(rProfessor);

        List <Tag> tags = new ArrayList<>();
        List <String> rTags = postProfessorTagsRequestBody.getrTags();

        for(String tId:rTags){
            Long id = IdHelper.getIdFromStringId(tId);

            Tag tag = new Tag();
            tag.settId(id);

            tags.add(tag);
        }

        if(tagDao.insertTagsBypId(tags, pId)){
            responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",null);
        }else{
            responseBody = new ResponseBody(ResponseBody.CREATE_TAGS_ERROR,"数据库错误",null);
        }

        return responseBody;
    }
}
