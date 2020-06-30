package com.shinstealler.talkative.api;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
@Aspect
public class RestApiControllerAdviser extends ResponseEntityExceptionHandler {
    
}