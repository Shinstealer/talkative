package com.shinstealler.talkative.api;

import javax.servlet.http.HttpServletRequest;

import com.shinstealler.talkative.exception.CEmailLoginException;
import com.shinstealler.talkative.model.response.CommonResult;
import com.shinstealler.talkative.service.ResponseService;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@Aspect
@RequiredArgsConstructor
public class RestApiControllerAdviser extends ResponseEntityExceptionHandler {

    private final ResponseService responseService;

    @ExceptionHandler(CEmailLoginException.class)
    protected ResponseEntity<CommonResult> serNotFoundException(HttpServletRequest request, CEmailLoginException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseService.getFailResult());

    }

}