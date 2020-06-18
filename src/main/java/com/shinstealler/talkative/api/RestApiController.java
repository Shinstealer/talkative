package com.shinstealler.talkative.api;

import com.shinstealler.talkative.domain.note.PostRepository;
import com.shinstealler.talkative.model.PostSaveRequestModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/shinstealer/talkative")
public class RestApiController {

    private PostRepository postRepository;

    public RestApiController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping("/note/post")
    public void savePost(@RequestBody PostSaveRequestModel request) {
        log.info("request save post " + request);
        postRepository.save(request.toEntity());
    }

}