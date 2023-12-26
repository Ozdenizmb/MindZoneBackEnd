package com.mindzone.backend.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class User {

    private UUID id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String phoneNumber;
    private int age;
    private String gender;
    private String education;
    private int financialSituation;
    private String chronicDisease;
    private String psychology;

}
