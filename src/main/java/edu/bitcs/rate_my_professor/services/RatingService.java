package edu.bitcs.rate_my_professor.services;

import edu.bitcs.rate_my_professor.dtos.request_body.LikeOrDislikeRatingByrIdRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.PostRatingRequestBody;
import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;

import javax.servlet.http.HttpSession;

public interface RatingService {
    ResponseBody getRatingInfoByrId(String rId);
    ResponseBody getRatingInfoBypId(String pId,String offset,String limit);
    ResponseBody getRatingInfoByuEmail(HttpSession httpSession, String offset, String limit);
    ResponseBody postRating(HttpSession httpSession,PostRatingRequestBody postRatingRequestBody);
    ResponseBody likeOrDislikeRatingByrId(LikeOrDislikeRatingByrIdRequestBody likeOrDislikeRatingByrIdRequestBody,
                                          String rId);
}
