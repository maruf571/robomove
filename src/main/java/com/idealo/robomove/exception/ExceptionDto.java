package com.idealo.robomove.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class ExceptionDto {

    private final Date timestamp;

    private final String message;

    private final String details;

}
