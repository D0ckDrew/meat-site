package com.meatSite.meatSiteBackend.auth.model;

public enum RegistrationStatus {
    SUCCESSFULLY(0, "Успешно!"),
    USER_ALREADY_EXISTS(1, "Пользователь с данным никнеймом уже существует!"),
    INVALID_REGISTRATION_DATA(2, "Неверные данные регистрации!");

    int index;
    String message;

    RegistrationStatus(int index, String message) {
        this.index = index;
        this.message = message;
    }
}
