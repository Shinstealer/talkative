package com.shinstealler.talkative.config;

import com.shinstealler.talkative.service.member.MemberService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private MemberService memberService;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Override
    public void configure(WebSecurity security) throws Exception {
        security.ignoring().antMatchers("/css_lib/**", "/js_lib/**", "/img/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.
        authorizeRequests()
                // 페이지 권한 설정
                .antMatchers("/shinstealer/talkative/admin/**").hasRole("ADMIN")
                .antMatchers("/shinstealer/talkative/user/myinfo").hasRole("MEMBER")
                .antMatchers("/shinstealer/talkative/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .and() // 로그인 설정
                .formLogin()
                .loginPage("/shinstealer/talkative/user/login")
                .defaultSuccessUrl("/shinstealer/talkative/user/login/result").permitAll()
                .and() // 로그아웃                                                                                           
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/shinstealer/talkative/user/logout"))
                .logoutSuccessUrl("/shinstealer/talkative/user/logout/result")
                .invalidateHttpSession(true)
                .and()
                // 403 예외처리 핸들링
                .exceptionHandling()
                .accessDeniedPage("/shinstealer/talkative/user/denied");
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }

}