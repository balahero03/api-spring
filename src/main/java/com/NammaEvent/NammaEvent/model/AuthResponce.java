package com.NammaEvent.NammaEvent.model;

public class AuthResponce {
    private String AccessToken;
    private String RefreshToken;

    public AuthResponce(){

    }

    public AuthResponce(String accessToken, String refreshToken) {
        AccessToken = accessToken;
        RefreshToken = refreshToken;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    public String getRefreshToken() {
        return RefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        RefreshToken = refreshToken;
    }
}
