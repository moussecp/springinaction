package web.quotes.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.quotes.exception.QuoteNotFoundException;
import web.quotes.exception.UserAlreadyExistsException;
import web.quotes.web.rest.RequestError;

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
