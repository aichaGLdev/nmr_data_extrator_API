package com.MAPS_IT.CpMolGen.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationResponse {
    private int userId;
    private String token;

}
