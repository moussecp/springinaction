package com.hermes.training.spring.quotes.web;

import com.hermes.training.spring.quotes.data.quote.QuoteNotFoundException;
import com.hermes.training.spring.quotes.data.user.UserAlreadyExistsException;
import com.hermes.training.spring.quotes.web.rest.RequestError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    //rest call exception handler
    @ExceptionHandler(QuoteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RequestError handleQuoteNotFoundException() {
        return new RequestError(42, "quote not found");
    }
}
