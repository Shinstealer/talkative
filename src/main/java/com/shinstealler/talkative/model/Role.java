package com.shinstealler.talkative.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

    ADMIN("ADMIN"), 
    MEMBER("MEMBER");

    private final String value;

}