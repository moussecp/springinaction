package com.hermes.training.spring.quotes.web;

import com.hermes.training.spring.quotes.data.user.UserAlreadyExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public String handleDuplicateExceptions() {
        return "error-duplicate";
    }

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public String handleBadDataExceptions() {
        return "error-missing-field";
    }

}
