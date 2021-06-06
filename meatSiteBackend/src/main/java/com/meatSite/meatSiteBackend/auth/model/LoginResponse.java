package com.meatSite.meatSiteBackend.auth.model;

import com.meatSite.meatSiteBackend.response.Response;

public class LoginResponse {
    private Response loginStatus;
    private String token;

    public LoginResponse(LoginStatus loginStatus, String token) {
        this.loginStatus = loginStatus.getResponse();
        this.token = token;
    }

    public LoginResponse(LoginStatus loginStatus) {
        this.loginStatus = loginStatus.getResponse();
    }

    public Response getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(LoginStatus loginStatus) {
        this.loginStatus = loginStatus.getResponse();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
