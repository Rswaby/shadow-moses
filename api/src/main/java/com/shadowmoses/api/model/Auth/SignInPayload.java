package com.shadowmoses.api.model.Auth;

import com.shadowmoses.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SignInPayload {
    private final String token;
    private final User user;
}
