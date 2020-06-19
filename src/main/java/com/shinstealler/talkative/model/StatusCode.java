package com.shinstealler.talkative.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum StatusCode {

    SUCCESS("WORK_SUCCESS"), ERROR("WORK_ERROR");

    private final String message;

    private StatusCode(String message) {

        this.message = message;
    }

}