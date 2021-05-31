package com.meatSite.meatSiteBackend.auth.model;

public class LoginResponse {
    private LoginStatus loginStatus;
    private String token;

    public LoginResponse(LoginStatus loginStatus, String token) {
        this.loginStatus = loginStatus;
        this.token = token;
    }

    public LoginResponse(LoginStatus loginStatus) {
        this.loginStatus = loginStatus;
    }

    public LoginStatus getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(LoginStatus loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
