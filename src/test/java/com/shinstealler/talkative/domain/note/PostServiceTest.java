package com.shinstealler.talkative.domain.note;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.shinstealler.talkative.service.note.PostService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PostServiceTest {

    @Mock
    PostRepository postRepository;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deleteTest(){
        long id = 123;

        PostService service = new PostService(postRepository);
        service.deletePost(id);

        verify(postRepository , times(1)).deleteById(id);
    }
    
}