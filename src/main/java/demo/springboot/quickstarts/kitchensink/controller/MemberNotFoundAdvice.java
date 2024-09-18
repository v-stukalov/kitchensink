package demo.springboot.quickstarts.kitchensink.controller;

import demo.springboot.quickstarts.kitchensink.exception.MemberNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberNotFoundAdvice {
    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String memberNotFoundHandler(MemberNotFoundException ex) {
        return ex.getMessage();
    }
}
