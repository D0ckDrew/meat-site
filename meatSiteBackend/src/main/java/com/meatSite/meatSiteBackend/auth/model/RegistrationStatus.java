package com.meatSite.meatSiteBackend.auth.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meatSite.meatSiteBackend.response.Response;

public enum RegistrationStatus {
    SUCCESSFULLY(0, "Успешно!"),
    USER_ALREADY_EXISTS(1, "Пользователь с данным никнеймом уже существует!"),
    INVALID_REGISTRATION_DATA(2, "Неверные данные регистрации!");

    private int code;
    private String message;

    RegistrationStatus(int code, String message) {
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
