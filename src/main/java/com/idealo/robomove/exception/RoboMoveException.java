package com.idealo.robomove.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class RoboMoveException extends RuntimeException{

    private final String message;

    private final HttpStatus httpStatus;
}
