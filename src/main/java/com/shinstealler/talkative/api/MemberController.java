package com.shinstealler.talkative.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@AllArgsConstructor
public class MemberController {

    @GetMapping("/user/signup")
    public String newSignup(){
        return "/member/signup";
    }

    
}