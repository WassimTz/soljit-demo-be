package com.soljit.touzene.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class AllCandidatureResponse {
    @JsonProperty(value = "objectDescribe")
    ObjectDescribe objectDescribe;
    @JsonProperty(value = "recentItems")
    List<RecentItemModel> recentItemModels;
}
