package ru.clevertec.client.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.clevertec.client.exceptions.ErrorCode;
import ru.clevertec.client.exceptions.NotFoundException;
import ru.clevertec.client.models.responses.ErrorResponse;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(NotFoundException e) {
        ErrorResponse response = new ErrorResponse(e.getIncorrectValue(), e.getMessage(), e.getErrorCode().getCode());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception e) {
        ErrorResponse response = new ErrorResponse(e.getMessage(), ErrorCode.SERVER_ERROR.getCode());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
