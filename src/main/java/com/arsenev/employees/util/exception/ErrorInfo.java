package com.arsenev.employees.util.exception;

//TODO: create description

public class ErrorInfo {
    private final String url;
    private final ErrorType type;
    private final String typeMessage;

    public ErrorInfo(CharSequence url, ErrorType type, String typeMessage) {
        this.url = url.toString();
        this.type = type;
        this.typeMessage = typeMessage;
    }

    public String getUrl() {
        return url;
    }

    public ErrorType getType() {
        return type;
    }

    public String getTypeMessage() {
        return typeMessage;
    }
}
