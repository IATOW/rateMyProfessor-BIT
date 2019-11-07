package edu.bitcs.rate_my_professor.controllers;

import edu.bitcs.rate_my_professor.dtos.response_body.ResponseBody;
import edu.bitcs.rate_my_professor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/professors")
public class ProfessorsController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/{pId}")
    public ResponseBody getProfessorInfoBypId(@PathVariable String pId){
        return professorService.getProfessorInfoBypId(pId);
    }
}
