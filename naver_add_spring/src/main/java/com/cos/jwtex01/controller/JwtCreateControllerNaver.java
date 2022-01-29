package com.cos.jwtex01.controller;

import java.util.Date;
import java.util.Map;

import com.cos.jwtex01.config.oauth.provider.NaverUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.jwtex01.config.jwt.JwtProperties;
import com.cos.jwtex01.config.oauth.provider.GoogleUser;
import com.cos.jwtex01.config.oauth.provider.OAuthUserInfo;
import com.cos.jwtex01.model.User;
import com.cos.jwtex01.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JwtCreateControllerNaver {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/jwt/naver")
    public String jwtCreate(@RequestBody Map<String, Object> data) {
        System.out.println("jwtCreate 실행됨");
        System.out.println(data);
        OAuthUserInfo naverUser =
                new NaverUser((Map<String, Object>)data);

        User naveruserinfo =
                userRepository.findByUsername(naverUser.getProvider()+"_"+naverUser.getProviderId());


        if(naveruserinfo == null) {
            System.out.println("naveruser is null");
            User userRequest = User.builder()
                    .username(naverUser.getProvider()+"_"+naverUser.getProviderId())
                    .password(bCryptPasswordEncoder.encode("겟인데어"))
                    .email(naverUser.getEmail())
                    .provider(naverUser.getProvider())
                    .providerId(naverUser.getProviderId())
                    .roles("ROLE_USER")
                    .build();

            naveruserinfo = userRepository.save(userRequest);
        }else{
            System.out.println("userEntity is not null");
        }


        String jwtTokenNaver = JWT.create()
                .withSubject(naveruserinfo.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
                .withClaim("id", naveruserinfo.getId())
                .withClaim("username", naveruserinfo.getUsername())
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));

        return jwtTokenNaver;
    }

}