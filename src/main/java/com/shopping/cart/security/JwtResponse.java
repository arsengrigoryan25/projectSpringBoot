package com.shopping.cart.security;

// После успешной аутентификации возвращается сервером SpringBoot, он состоит из 2 частей:
public class JwtResponse {
    private String jwtToken;
    private String type = "Bearer";

    public JwtResponse(String accessToken) {
        this.jwtToken = accessToken;
    }

    public String getAccessToken() {
        return jwtToken;
    }
    public void setAccessToken(String accessToken) {
        this.jwtToken = accessToken;
    }

    public String getTokenType() {
        return type;
    }
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
}