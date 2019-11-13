package edu.bitcs.rate_my_professor.services;

import edu.bitcs.rate_my_professor.daos.RatingDao;
import edu.bitcs.rate_my_professor.daos.RatingDaoImpl;
import edu.bitcs.rate_my_professor.dtos.request_body.LikeOrDislikeRatingByrIdRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.LogInRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.PostRatingRequestBody;
import edu.bitcs.rate_my_professor.dtos.response_body.*;
import edu.bitcs.rate_my_professor.pos.Course;
import edu.bitcs.rate_my_professor.pos.Professor;
import edu.bitcs.rate_my_professor.pos.Rating;
import edu.bitcs.rate_my_professor.pos.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingDao ratingDao;

    @Override
    public ResponseBody getRatingInfoByrId(String rId) {
        ResponseBody responseBody;

        if(rId==null){
            responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
        }else{
            Long id = IdHelper.getIdFromStringId(rId);

            if(id==null){
                responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
            }else {
                Map<String,Object> map = ratingDao.getRatingAndRelatedTagsAndCourseByrId(id);

                Rating rating = (Rating) map.get("rating");
                List<Tag> tags = (List<Tag>) map.get("tags");
                Course course = (Course) map.get("course");

                if(rating==null||tags==null||course==null){
                    responseBody = new ResponseBody(ResponseBody.GET_RATING_ERROR,"数据库错误",null);
                }else{
                    responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",new RatingInfoByrId(rating,tags,
                            course));
                }
            }
        }
        return responseBody;
    }

    @Override
    public ResponseBody getRatingInfoBypId(String pId, String offset, String limit) {
        ResponseBody responseBody;

        if(pId==null){
            responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
        }else{
            Long id = IdHelper.getIdFromStringId(pId);

            if(id==null){
                responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
            }else{
                if(offset==null&&limit==null){
                    Map<String,Object> map = ratingDao.getRatingsAndRelatedTagsAndCourseBypId(id);

                    List<Rating> ratings = (List<Rating>) map.get("ratings");
                    List<List<Tag>> tagss = (List<List<Tag>>) map.get("tagss");
                    List<Course> courses = (List<Course>) map.get("courses");

                    long total = ratingDao.getTotalNumber();

                    if(ratings==null||tagss==null||courses==null){
                        responseBody = new ResponseBody(ResponseBody.GET_RATING_ERROR,"数据库错误",null);
                    }else{
                        responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",new RatingInfoBypId(
                                0, Link.LIMIT, total, ratings, tagss, courses, pId));
                    }
                }else if(offset!=null&&limit!=null){
                    try{
                        long offsetLong = Long.parseLong(offset);
                        long limitLong = Long.parseLong(limit);

                        Map<String,Object> map = ratingDao.getRatingsAndRelatedTagsAndCourseBypIdWithOffsetAndLimit(id,
                                offsetLong, limitLong);

                        List<Rating> ratings = (List<Rating>) map.get("ratings");
                        List<List<Tag>> tagss = (List<List<Tag>>) map.get("tagss");
                        List<Course> courses = (List<Course>) map.get("courses");

                        long total = ratingDao.getTotalNumber();

                        if(ratings==null||tagss==null||courses==null){
                            responseBody = new ResponseBody(ResponseBody.GET_RATING_ERROR,"数据库错误",null);
                        }else{
                            responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",new RatingInfoBypId(
                                    offsetLong, limitLong, total, ratings, tagss, courses, pId));
                        }
                    }catch (NumberFormatException e){
                        responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
                    }
                }else{
                    responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
                }
            }
        }

        return responseBody;
    }

    @Override
    public ResponseBody getRatingInfoByuEmail(HttpSession httpSession, String offset, String limit) {
        ResponseBody responseBody;

        if(httpSession==null||httpSession.getAttribute(UserServiceImpl.LOG_IN_REQUEST_BODY)==null){
            responseBody = new ResponseBody(ResponseBody.INVALID_SESSION,"无效的会话",null);
        }else{
            LogInRequestBody logInRequestBody = (LogInRequestBody)httpSession.getAttribute(UserServiceImpl.LOG_IN_REQUEST_BODY);

            String uEmail = logInRequestBody.getuEmail();

            if(offset==null&&limit==null){
                Map<String,Object> map = ratingDao.getRatingsAndRelatedTagsAndCourseAndProfessorByuEmail(uEmail);

                List<Rating> ratings = (List<Rating>) map.get("ratings");
                List<List<Tag>> tagss = (List<List<Tag>>) map.get("tagss");
                List<Course> courses = (List<Course>) map.get("courses");
                List<Professor> professors = (List<Professor>) map.get("professors");

                long total = ratingDao.getTotalNumber();

                if(ratings==null||tagss==null||courses==null||professors==null){
                    responseBody = new ResponseBody(ResponseBody.GET_RATING_ERROR,"数据库错误",null);
                }else{
                    responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",new RatingInfoByuEmail(0,
                            Link.LIMIT, total, ratings, tagss, courses, professors));
                }
            }else if(offset!=null&&limit!=null){
                try{
                    long offsetLong = Long.parseLong(offset);
                    long limitLong = Long.parseLong(limit);

                    Map<String,Object> map = ratingDao.
                            getRatingsAndRelatedTagsAndCourseAndProfessorByuEmailWithOffsetAndLimit(
                                    uEmail, offsetLong, limitLong);

                    List<Rating> ratings = (List<Rating>) map.get("ratings");
                    List<List<Tag>> tagss = (List<List<Tag>>) map.get("tagss");
                    List<Course> courses = (List<Course>) map.get("courses");
                    List<Professor> professors = (List<Professor>) map.get("professors");

                    long total = ratingDao.getTotalNumber();

                    if(ratings==null||tagss==null||courses==null){
                        responseBody = new ResponseBody(ResponseBody.GET_RATING_ERROR,"数据库错误",null);
                    }else{
                        responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",new RatingInfoByuEmail(
                                offsetLong, limitLong, total, ratings, tagss, courses, professors));
                    }
                }catch (NumberFormatException e){
                    responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
                }
            }else{
                responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
            }
        }

        return responseBody;
    }

    @Override
    public ResponseBody postRating(HttpSession httpSession, PostRatingRequestBody postRatingRequestBody) {
        ResponseBody responseBody;

        if(httpSession==null||httpSession.getAttribute(UserServiceImpl.LOG_IN_REQUEST_BODY)==null){
            responseBody = new ResponseBody(ResponseBody.INVALID_SESSION,"无效的会话",null);
        }else {
            LogInRequestBody logInRequestBody = (LogInRequestBody)httpSession.getAttribute(UserServiceImpl.LOG_IN_REQUEST_BODY);

            String uEmail = logInRequestBody.getuEmail();

            Rating rating = null;

            try {
                rating = new Rating(postRatingRequestBody, uEmail);
            }
            catch (NullPointerException e) {
                responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
                return responseBody;
            }

            List<Tag> tags = new ArrayList<>();

            List<String> rTags = postRatingRequestBody.getrTags();

            boolean istIdParamWrong = false;

            for(String tId:rTags) {
                Long id = IdHelper.getIdFromStringId(tId);

                if(id==null) {
                    istIdParamWrong = true;
                    break;
                }
                else{
                    Tag tag = new Tag();
                    tag.settId(id);

                    tags.add(tag);
                }
            }

            if(istIdParamWrong){
                responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
            }else{
                if(ratingDao.insertRatingAndRelatedTags(rating,tags)){
                    responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",null);
                }else{
                    responseBody = new ResponseBody(ResponseBody.CREATE_RATING_ERROR,"数据库错误",null);
                }
            }
        }

        return responseBody;
    }

    @Override
    public ResponseBody likeOrDislikeRatingByrId(
            LikeOrDislikeRatingByrIdRequestBody likeOrDislikeRatingByrIdRequestBody, String rId) {
        ResponseBody responseBody;

        if(rId==null){
            responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
        }else{
            Long id = IdHelper.getIdFromStringId(rId);

            if(id==null){
                responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
            }else{
                boolean isDataBaseSucceed = true;
                if(likeOrDislikeRatingByrIdRequestBody.getAction().
                        equals(LikeOrDislikeRatingByrIdRequestBody.LIKE_RATING)){

                    if(!ratingDao.addOneOnRatingByrId(id)){
                        isDataBaseSucceed = false;
                    }

                }else if (likeOrDislikeRatingByrIdRequestBody.getAction().
                        equals(LikeOrDislikeRatingByrIdRequestBody.DISLIKE_RATING)){

                    if(!ratingDao.minusOneOnRatingByrId(id)){
                        isDataBaseSucceed = false;
                    }

                }else{
                    responseBody = new ResponseBody(ResponseBody.WRONG_PARAMS,"参数错误",null);
                    return responseBody;
                }

                if(isDataBaseSucceed){
                    responseBody = new ResponseBody(ResponseBody.SUCCESS,"成功",null);
                }else{
                    responseBody = new ResponseBody(ResponseBody.UPDATE_RATING_ERROR,"数据库错误",null);
                }
            }
        }

        return responseBody;
    }
}
