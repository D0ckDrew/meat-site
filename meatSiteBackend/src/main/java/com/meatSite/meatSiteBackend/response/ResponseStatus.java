package com.meatSite.meatSiteBackend.response;

public enum ResponseStatus {
    SUCCESSFULLY(0, "Успешно!"),
    VALIDATION_ERROR(1, "Ошибка валидации данных!"),
    SERVER_ERROR(2, "Ошибка сервера! Пожалуйста, обратитесь к администратору системы.");

    private int code;
    private String message;

    ResponseStatus(int code, String message) {
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
