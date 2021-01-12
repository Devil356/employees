package com.arsenev.employees.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 422 ошибка
 * http://stackoverflow.com/a/22358422/548473
 */
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "No data found")
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
