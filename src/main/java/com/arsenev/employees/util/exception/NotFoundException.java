package com.arsenev.employees.util.exception;

/**
 * При отсутствии объекта в базе по id, выбрасывается данный эксепшен.
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
