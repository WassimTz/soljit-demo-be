package com.soljit.touzene.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CandidatureModel {
    @JsonProperty(value = "Id")
    String id;
    @JsonProperty(value = "First_Name__c")
    String firstName;
    @JsonProperty(value = "Last_Name__c")
    String lastName;
    @JsonProperty(value = "Year__c")
    String year;
    @JsonProperty(value = "Year_Of_Experience__c")
    String yearOfExperience;
}
