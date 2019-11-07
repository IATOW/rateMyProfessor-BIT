package edu.bitcs.rate_my_professor.controllers;


import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//todo
@RestController
@RequestMapping("/search")
public class SearchController {
    @GetMapping("")
    public ResponseBody search(@RequestParam("query")String query,@RequestParam("offset")String offset,
                               @RequestParam("limit")String limit){
        return null;
    }
}
