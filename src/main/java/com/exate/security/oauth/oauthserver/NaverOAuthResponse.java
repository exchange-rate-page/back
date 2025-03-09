package com.exate.security.oauth.oauthserver;

import com.exate.security.oauth.OAuthResponse;
import com.exate.security.oauth.OAuthServer;

import java.util.Map;

public class NaverOAuthResponse implements OAuthResponse {

    private final Map<String, Object> res;

    public NaverOAuthResponse(final Map<String, Object> res) {
        this.res = (Map<String, Object>) res.get("response");
    }

    @Override
    public OAuthServer getProvider() {
        return OAuthServer.NAVER;
    }

    @Override
    public String getPicture() {
        return res.get("profile_image").toString();
    }

    @Override
    public String getEmail() {
        return res.get("email").toString();
    }

    @Override
    public String getName() {
        return res.get("name").toString();
    }
}
