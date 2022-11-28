package com.soljit.touzene.demo.controller;

import com.soljit.touzene.demo.model.CandidatureCreationModel;
import com.soljit.touzene.demo.model.CandidatureModel;
import com.soljit.touzene.demo.model.GenericResponse;
import com.soljit.touzene.demo.model.GenericResponseExtended;
import com.soljit.touzene.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/private")
public class CandidatureController {

    @Autowired
    CandidateService candidateService;

    @GetMapping("/candidature")
    public GenericResponseExtended<CandidatureModel> getCandidature(@RequestAttribute String authorization, @RequestParam(required = false, defaultValue = "a004L000002gCJK") String candidatureId){
        return candidateService.getCandidatureById(authorization, candidatureId);
    }
    @PostMapping("/candidature")
    public GenericResponseExtended<CandidatureCreationModel> addCandidature(@RequestAttribute String authorization, @RequestBody CandidatureModel candidature){
        return candidateService.addCandidature(authorization, candidature);
    }
    @PatchMapping("/candidature")
    public GenericResponse editCandidature(@RequestAttribute String authorization, @RequestBody CandidatureModel candidature, @RequestParam String id){
        return candidateService.editCandidature(authorization, candidature, id);
    }

    @GetMapping("/candidatures")
    public GenericResponseExtended<List<CandidatureModel>> getAllCandidature(@RequestAttribute String authorization){
        return candidateService.getAllCandidature(authorization);
    }
}
