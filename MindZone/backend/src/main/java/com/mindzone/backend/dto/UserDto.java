package com.mindzone.backend.dto;


import java.util.UUID;

public record UserDto(
        UUID id,
        String firstName,
        String lastName,
        String eMail,
        String phoneNumber,
        int age,
        String gender,
        String education,
        int financialSituation,
        String chronicDisease,
        String psychology
) {
}
