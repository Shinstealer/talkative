package com.shinstealler.talkative.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.shinstealler.talkative.domain.member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberResponseModel {

    private long memId;
    private String email;
    private String password;
    private String modifiedDate;
    private String createDate;

    @Builder
    public MemberResponseModel(Member entity) {
        this.memId = entity.getMemId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.modifiedDate = toStringDateTime(entity.getModifiedDate());
        this.createDate = toStringDateTime(entity.getCreateDate());
    }

    private String toStringDateTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(time).map(formatter::format).orElse("");
    }
}