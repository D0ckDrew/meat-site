package com.meatSite.meatSiteBackend.auth.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meatSite.meatSiteBackend.response.Response;
import org.springframework.http.HttpStatus;

public enum LoginStatus {
    SUCCESSFULLY(0, "Успешно!"),
    INVALID_LOGIN_DATA(1, "Данные для входа введены неверно!");

    private int code;
    private String message;

    LoginStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Response getResponse(){
        return new Response(this.code, this.message);
    }
}
