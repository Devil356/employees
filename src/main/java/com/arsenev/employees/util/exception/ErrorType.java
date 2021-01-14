package com.arsenev.employees.util.exception;

/**
 * Типы ошибок для передачи в класс ErrorInfo, который является объектом для
 * передачи на UI.
 */
public enum ErrorType {
    APP_ERROR, //Internal Server Error (500), common errors
    DATA_NOT_FOUND, //NotFoundException
    DATA_ERROR, //Conflict Data (email)
    VALIDATION_ERROR //Invalid data
}
