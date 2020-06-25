package com.shinstealler.talkative.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.shinstealler.talkative.domain.note.Post;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostResponseModel {
    private long id;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;
    private String createDate;

    public PostResponseModel(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = toStringDateTime(entity.getModifiedDate());
        this.createDate = toStringDateTime(entity.getCreateDate());
    }

    private String toStringDateTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(time).map(formatter::format).orElse("");
    }

}