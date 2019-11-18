package edu.bitcs.rate_my_professor.controllers;

import edu.bitcs.rate_my_professor.dtos.request_body.LikeOrDislikeRatingByrIdRequestBody;
import edu.bitcs.rate_my_professor.dtos.request_body.PostRatingRequestBody;
import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@CrossOrigin
@RestController
@RequestMapping("/ratings")
public class RatingsController {
    @Autowired
    private RatingService ratingService;

    @GetMapping("/{rId}")
    public ResponseBody getRatingInfoByrId(@PathVariable String rId){
        return ratingService.getRatingInfoByrId(rId);
    }

    @GetMapping("")
    public ResponseBody getRatingInfoBypIdOrByuEmail(HttpServletRequest httpServletRequest,
                                                     @RequestParam(value = "pId",required = false)String pId,
                                                  @RequestParam(value = "offset",required = false) String offset,
                                                  @RequestParam(value = "limit",required = false) String limit){
        if(pId==null){
            return ratingService.getRatingInfoByuEmail(httpServletRequest.getSession(false),offset,limit);
        }else{
            return ratingService.getRatingInfoBypId(pId,offset,limit);
        }
    }

    @PostMapping("")
    public ResponseBody postRating(HttpServletRequest httpServletRequest,
                                   @RequestBody PostRatingRequestBody postRatingRequestBody){
        return ratingService.postRating(httpServletRequest.getSession(false),postRatingRequestBody);
    }

    @PatchMapping("/{rId}")
    public ResponseBody likeOfDislikeRatingByrId(
            @RequestBody LikeOrDislikeRatingByrIdRequestBody likeOrDislikeRatingByrIdRequestBody,
            @PathVariable String rId){
        return ratingService.likeOrDislikeRatingByrId(likeOrDislikeRatingByrIdRequestBody,rId);
    }
}
