package com.hermes.training.spring.quotes.data.user;

import org.springframework.dao.DuplicateKeyException;

public class UserAlreadyExistsException extends DuplicateKeyException{

    public static String BASE_MESSAGE = "a user with that name already exists: ";

    public UserAlreadyExistsException(String msg) {
        super(BASE_MESSAGE + msg);
    }

    public UserAlreadyExistsException(String msg, Throwable cause) {
        super(BASE_MESSAGE + msg, cause);
    }
}
