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
public class JwtCreateController {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/jwt/google")
	public String jwtCreate(@RequestBody Map<String, Object> data) {
		System.out.println("jwtCreate 실행됨");
		System.out.println(data.get("profileObj"));
		OAuthUserInfo googleUser =
				new GoogleUser((Map<String, Object>)data.get("profileObj"));
		
		User googleuserinfo =
				userRepository.findByUsername(googleUser.getProvider()+"_"+googleUser.getProviderId());


		if(googleuserinfo == null) {
			System.out.println("googleuser is null");
			User userRequest = User.builder()
					.username(googleUser.getProvider()+"_"+googleUser.getProviderId())
					.password(bCryptPasswordEncoder.encode("겟인데어"))
					.email(googleUser.getEmail())
					.provider(googleUser.getProvider())
					.providerId(googleUser.getProviderId())
					.roles("ROLE_USER")
					.build();
			
			googleuserinfo = userRepository.save(userRequest);
		}else{
			System.out.println("userEntity is not null");
		}

		
		String jwtToken = JWT.create()
				.withSubject(googleuserinfo.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
				.withClaim("id", googleuserinfo.getId())
				.withClaim("username", googleuserinfo.getUsername())
				.sign(Algorithm.HMAC512(JwtProperties.SECRET));
		
		return jwtToken;
	}
	
}
