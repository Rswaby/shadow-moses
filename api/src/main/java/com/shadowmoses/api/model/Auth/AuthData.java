package com.shadowmoses.api.model.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthData {
    private final String email;
    private final String password;
}
