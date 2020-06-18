package com.shinstealler.talkative.model;

import com.shinstealler.talkative.domain.note.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostSaveRequestModel {

    private String title;
    private String content;
    private String author;

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
    
}