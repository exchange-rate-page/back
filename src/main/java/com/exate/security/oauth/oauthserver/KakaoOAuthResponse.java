package com.exate.security.oauth.oauthserver;

import com.exate.security.oauth.OAuthResponse;
import com.exate.security.oauth.OAuthServer;

import java.util.Map;

public class KakaoOAuthResponse implements OAuthResponse {

    private final Map<String, Object> res;

    public KakaoOAuthResponse(final Map<String, Object> res) {
        this.res = (Map<String, Object>)res.get("kakao_account");
    }

    @Override
    public OAuthServer getProvider() {
        return OAuthServer.KAKAO;
    }

    @Override
    public String getPicture() {
        Map<String, Object> data = (Map<String, Object>) res.get("profile");
        return data.get("profile_image_url").toString();
    }

    @Override
    public String getEmail() {
        return res.get("email").toString();
    }

    @Override
    public String getName() {
        Map<String, Object> data = (Map<String, Object>) res.get("profile");
        return data.get("nickname").toString();
    }
}
