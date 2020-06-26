package com.shinstealler.talkative.service.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.shinstealler.talkative.domain.member.Member;
import com.shinstealler.talkative.domain.member.MemberRepository;
import com.shinstealler.talkative.model.MemberRequestModel;
import com.shinstealler.talkative.model.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository repository;
	

    @Transactional
    public long join(final MemberRequestModel model) {
        final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        return repository.save(model.toEntity()).getMemId();
    }

    
    public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {
        Optional<Member> userEntityWrapper = repository.findByEmail(memberEmail);
        Member userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(memberEmail)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }

}