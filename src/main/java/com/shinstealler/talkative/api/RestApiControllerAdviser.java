package com.shinstealler.talkative.api;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
@Aspect
public class RestApiControllerAdviser extends ResponseEntityExceptionHandler {
    
}