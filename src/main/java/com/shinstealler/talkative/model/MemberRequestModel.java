package com.shinstealler.talkative.model;

import com.shinstealler.talkative.domain.member.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberRequestModel {

    private long memId;
    private String email;
    private String password;

    public Member toEntity() {
        return Member.builder()
        .memId(memId)
        .email(email)
        .password(password)
        .build();
    }

}