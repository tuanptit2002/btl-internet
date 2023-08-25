package com.example.BTL_INTERNET_GT.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    public String access_token;
    private String refresh_token;
    private String user_name;
    private String email;
}
