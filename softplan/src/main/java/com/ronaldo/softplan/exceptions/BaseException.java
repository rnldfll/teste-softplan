package com.ronaldo.softplan.exceptions;

public abstract class BaseException extends RuntimeException {
    public int statusCode;

    public BaseException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
