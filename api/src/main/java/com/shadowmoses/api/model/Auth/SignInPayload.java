package com.shadowmoses.api.model.Auth;

import com.shadowmoses.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInPayload {
    private  String token;
    private  User user;
}
