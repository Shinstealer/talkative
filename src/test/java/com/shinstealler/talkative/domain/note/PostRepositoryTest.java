package com.shinstealler.talkative.domain.note;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @AfterEach
    public void cleanUp() {
        postRepository.deleteAll();
    }

    @Test
    public void save() {
        postRepository.save(Post.builder().title("title").content("content").author("author").build());

        List<Post> postList = postRepository.findAll();

        Post post = postList.get(0);

        assertEquals("title", post.getTitle());
        assertEquals("content", post.getContent());
        assertEquals("author", post.getAuthor());
    }

    @Test
    public void register_baseTimeEntity() {
        LocalDateTime now = LocalDateTime.now();

        postRepository.save(Post.builder().title("title").content("content").author("author").build());

        List<Post> postList = postRepository.findAll();

        Post post = postList.get(0);

        assertThat(post.getCreateDate()).isAfter(now);
        assertThat(post.getModifiedDate()).isAfter(now);

    }

}