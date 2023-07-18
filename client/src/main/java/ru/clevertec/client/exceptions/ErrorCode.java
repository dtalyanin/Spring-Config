package ru.clevertec.client.exceptions;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NOT_FOUND(404), INCORRECT_ID(400), SERVER_ERROR(500);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }
}
