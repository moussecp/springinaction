package web.quotes.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import web.quotes.exception.UserAlreadyExistsException;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public String handleExceptions() {
        return "error-duplicate";
    }
}
