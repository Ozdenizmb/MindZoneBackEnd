package com.mindzone.backend.dto;

import jakarta.validation.constraints.NotNull;

public record UserCreateDto(
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        String eMail,
        @NotNull
        String password,
        @NotNull
        String phoneNumber,
        @NotNull
        int age,
        @NotNull
        String gender,
        @NotNull
        String education,
        @NotNull
        int financialSituation,
        @NotNull
        String chronicDisease,
        @NotNull
        String psychology
) {
}
