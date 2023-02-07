package com.blog.blogpost.writer;

import java.util.*;
import java.util.stream.*;

import org.springframework.http.*;
import org.springframework.web.context.request.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;

// @ResponseStatus(HttpStatus.BAD_REQUEST)
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler{
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
    HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webrequest){
        Map<String, Object> objectBody = new LinkedHashMap<>();
        objectBody.put("Current TimeStamp", new Date());
        objectBody.put("Status", httpStatus.value());

        // Getting all validation errors
        List<String> exceptionErrors = exception.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(x -> x.getDefaultMessage())
            .collect(Collectors.toList());

        objectBody.put("Errors", exceptionErrors);

        return new ResponseEntity<>(objectBody, httpStatus);
    }
}
