package edu.bitcs.rate_my_professor.services;

import edu.bitcs.rate_my_professor.dtos.request_body.LikeOrDislikeRatingByrIdRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.PostRatingRequestBody;
import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class RatingServiceImpl implements RatingService {

    @Override
    public ResponseBody getRatingInfoByrId(String rId) {
        return null;
    }

    @Override
    public ResponseBody getRatingInfoBypId(String pId, String offset, String limit) {
        return null;
    }

    @Override
    public ResponseBody getRatingInfoByuEmail(HttpSession httpSession, String offset, String limit) {
        return null;
    }

    @Override
    public ResponseBody postRating(PostRatingRequestBody postRatingRequestBody) {
        return null;
    }

    @Override
    public ResponseBody likeOrDislikeRatingByrId(
            LikeOrDislikeRatingByrIdRequestBody likeOrDislikeRatingByrIdRequestBody, String rId) {

        return null;
    }
}
