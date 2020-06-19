package com.shinstealler.talkative.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shinstealler.talkative.model.PostSaveRequestModel;
import com.shinstealler.talkative.service.note.PostService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/shinstealer/talkative")
public class RestApiController {

    private PostService postService;

    public RestApiController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/note")
    public void listPost(Model model) {
        model.addAttribute("post", postService.findAllDesc());
    }

    @PostMapping("/note/post")
    public void savePost(@RequestBody PostSaveRequestModel request) {
        log.info("request save post " + request);
        postService.createPost(request);
    }
    @GetMapping("note/delete/{id}")
    public String deletePost(HttpServletRequest request,@PathVariable("id") long id){
        
        HttpSession session = request.getSession();
        postService.deletePost(id);
        
        return "SUCCESS";
    }

}