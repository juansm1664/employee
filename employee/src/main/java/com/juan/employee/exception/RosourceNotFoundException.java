package com.juan.employee.exception;

public class RosourceNotFoundException extends RuntimeException{
    private static final long serialVersion = 1L;

    public RosourceNotFoundException(String message){
        super(message);
    }
}
