package com.cos.jwtex01.config.oauth.provider;

import org.yaml.snakeyaml.events.MappingStartEvent;

import java.util.Map;

public class NaverUser implements OAuthUserInfo{


    private Map<String, Object> attribute;

    public NaverUser(Map<String, Object> attribute) {
        this.attribute = attribute;
    }

    @Override
    public String getProviderId() {
        return (String)attribute.get("naverId");
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getEmail() {
        return (String)attribute.get("email");
    }

    @Override
    public String getName() {
        return (String)attribute.get("name");
    }
}
