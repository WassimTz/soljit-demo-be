package com.soljit.touzene.demo.service;

import com.soljit.touzene.demo.exception.CandidatureException;
import com.soljit.touzene.demo.model.*;
import com.soljit.touzene.demo.proxy.SalesforceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {
    @Autowired
    SalesforceService salesforceService;

    public GenericResponseExtended<CandidatureModel> getCandidatureById(String authorization, String id){
        if (id == null || id.isEmpty() ) {
            throw new CandidatureException(CandidatureException.MISSING_ID);
        }
        return new GenericResponseExtended<>(salesforceService.callCandidature(authorization, id));
    }

    public GenericResponseExtended<List<CandidatureModel>> getAllCandidature(String authorization){
        AllCandidatureResponse result = salesforceService.callAllCandidature(authorization);
        List<CandidatureModel> details = new ArrayList<>();
        result.getRecentItemModels().stream().forEach(recentItemModel -> {
            details.add(salesforceService.callCandidature(authorization, recentItemModel.getId()));
        });
        return new GenericResponseExtended<>(details);
    }

    public GenericResponseExtended<CandidatureCreationModel> addCandidature(String authorization, CandidatureModel candidature) {
        salesforceService.callCreateCandidature(authorization, candidature);
        return new GenericResponseExtended<CandidatureCreationModel>(salesforceService.callCreateCandidature(authorization, candidature));
    }

    public GenericResponse editCandidature(String authorization, CandidatureModel candidature, String id) {
        salesforceService.callEditCandidature(authorization, candidature, id);
        return new GenericResponse(GenericResponse.SUCCESS, 0);

    }
}
