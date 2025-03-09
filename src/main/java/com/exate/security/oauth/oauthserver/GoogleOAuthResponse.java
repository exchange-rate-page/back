package com.exate.security.oauth.oauthserver;

import com.exate.security.oauth.OAuthResponse;
import com.exate.security.oauth.OAuthServer;

import java.util.Map;

public class GoogleOAuthResponse implements OAuthResponse {

    private final Map<String, Object> res;

    public GoogleOAuthResponse(final Map<String, Object> res) {
        this.res = res;
    }

    @Override
    public OAuthServer getProvider() {
        return OAuthServer.GOOGLE;
    }

    @Override
    public String getPicture() {
        return res.get("picture").toString();
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
