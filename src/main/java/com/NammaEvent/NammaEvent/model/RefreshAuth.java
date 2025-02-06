package com.NammaEvent.NammaEvent.model;

public class RefreshAuth {
    private String RefreshToken;

    public RefreshAuth(){

    }

    public RefreshAuth(String refreshToken) {
        RefreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return RefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        RefreshToken = refreshToken;
    }
}
