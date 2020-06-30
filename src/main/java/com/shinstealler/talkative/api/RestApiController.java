package com.shinstealler.talkative.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shinstealler.talkative.model.PostSaveRequestModel;
import com.shinstealler.talkative.model.ResponseModel;
import com.shinstealler.talkative.model.StatusCode;
import com.shinstealler.talkative.service.note.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/shinstealer/talkative")
public class RestApiController {

    private PostService postService;

    public RestApiController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/note")
    public String listPost(HttpServletRequest request ,Model model) {
        model.addAttribute("post", postService.findAllPostDesc());
        return "/note/list";
    }

    // @PostMapping("/note/post")
    // public ResponseEntity<ResponseModel> savePost(HttpServletRequest request,
    //         @RequestBody PostSaveRequestModel saveRequest) {
    //     log.info("request save post " + request);

    //     try {
    //         postService.createPost(saveRequest);

    //         ResponseModel responseModel = new ResponseModel(StatusCode.SUCCESS);

    //         return ResponseEntity.ok(responseModel);

    //     } catch (Exception e) {
    //         log.error("Error:" , e);
    //         return new ResponseEntity<>(new ResponseModel(StatusCode.ERROR), HttpStatus.OK);
    //     }

    // }

    // @GetMapping("note/delete/{id}")
    // public String deletePost(HttpServletRequest request, @PathVariable("id") long id) {

    //     HttpSession session = request.getSession();
    //     postService.deletePost(id);

    //     return "redirect:/";
    // }

}