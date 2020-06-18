package com.shinstealler.talkative.domain.note;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @AfterEach
    public void cleanUp(){
        postRepository.deleteAll();
    }

    @Test
    public void save(){
        postRepository.save(
            Post.builder()
            .title("title")
            .content("content")
            .author("author")
            .build()
        );

        List<Post> postList = postRepository.findAll();

        Post post = postList.get(0);

        assertEquals("title", post.getTitle());
        assertEquals("content", post.getContent());
        assertEquals("author", post.getAuthor());
    }
    
}