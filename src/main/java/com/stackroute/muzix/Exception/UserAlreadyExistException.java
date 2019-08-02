package com.stackroute.muzix.Exception;

public class UserAlreadyExistException extends Exception { String messge;
    public UserAlreadyExistException(String message) {
        super(message);
        this.messge = message;

    }

    public UserAlreadyExistException() {
    }


}
