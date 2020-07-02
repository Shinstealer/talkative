package com.shinstealler.talkative.api;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinstealler.talkative.model.MemberRequestModel;
import com.shinstealler.talkative.service.member.MemberService;

import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Api(tags = {"1, user"})
@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/shinstealler/talkative")
public class MemberController {

    private MemberService memberService;

    
    @GetMapping("/user/signup")
    public String dispSignup() {
        log.info("move to sing up page");
        return "/user/signup";
    }

    @PostMapping("/user/signup")
    public String execSignup(HttpServletRequest request ,MemberRequestModel model) {

        memberService.join(model);

        // HttpRequest req = new ServletServerHttpRequest(request);
        // UriComponentsBuilder builder = UriComponentsBuilder.fromHttpRequest(req);
        // URI location = builder.path("/user/login").build().toUri();

        return "redirect:/shinstealer/talkative/user/login";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/user/login";
    }

    // 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "/user/loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/user/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/user/denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/user/myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/user/admin";
    }

    @GetMapping("encode-password")
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(request.getServletContext());
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

        String password = request.getParameter("pass");
        String encode = encoder.encode(password);

        log.info(encode);
    }

}