package com.idealo.robomove.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RoboMoveException.class)
    public final ResponseEntity<ExceptionDto> handleGeoDbFetchException(RoboMoveException ex, WebRequest request) {
        ExceptionDto exceptionDto = ExceptionDto.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionDto, ex.getHttpStatus());
    }
}
