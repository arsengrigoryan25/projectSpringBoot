package com.shopping.cart.message.response;

// После успешной аутентификации возвращается сервером SpringBoot, он состоит из 2 частей:
public class JwtResponse {
    private String token;
    private String type = "Bearer"; // todo anun@ poxel

    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }

    public String getAccessToken() {
        return token;
    }
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
}