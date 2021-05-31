package com.meatSite.meatSiteBackend.auth.model;

public enum LoginStatus {
    SUCCESSFULLY(0, "Успешно!"),
    INVALID_LOGIN_DATA(1, "Данные для входа введены неверно!");

    int index;
    String message;

    LoginStatus(int index, String message) {
        this.index = index;
        this.message = message;
    }
}
