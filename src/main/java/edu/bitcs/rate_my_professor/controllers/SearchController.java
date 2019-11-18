package edu.bitcs.rate_my_professor.controllers;


import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import org.springframework.web.bind.annotation.*;

//todo under construction
@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchController {
    @GetMapping("")
    public ResponseBody search(@RequestParam("query")String query,@RequestParam("offset")String offset,
                               @RequestParam("limit")String limit){
        return null;
    }
}
