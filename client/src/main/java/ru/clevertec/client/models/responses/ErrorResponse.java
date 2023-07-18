package ru.clevertec.client.models.responses;

public record ErrorResponse(Object incorrectValue, String errorMessage, int errorCode) {

    public ErrorResponse(String errorMessage, int errorCode) {
        this(null, errorMessage, errorCode);
    }
}
