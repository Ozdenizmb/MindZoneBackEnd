package com.mindzone.backend.dto;

import jakarta.validation.constraints.NotNull;

public record UserLoginDto(
        @NotNull
        String email,
        @NotNull
        String password
) {
}
