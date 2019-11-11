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
import java.util.Map;

@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagDao tagDao;

    @Override
    public ResponseBody getTags() {
        ResponseBody responseBody;

        ArrayList <Tag> tags = tagDao.getTags();

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

            ArrayList<Tag> tags = (ArrayList<Tag>) map.get("tags");
            ArrayList<Integer> numbers = (ArrayList<Integer>) map.get("numbers");

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

        ArrayList <Tag> tags = new ArrayList<>();
        ArrayList <String> rTags = postProfessorTagsRequestBody.getrTags();

        for(String tName:rTags){
            Tag tag = new Tag();
            tag.settName(tName);

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
