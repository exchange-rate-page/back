package com.exate.security.oauth;

public interface OAuthResponse {
    OAuthServer getProvider();
    String getPicture();
    String getEmail();
    String getName();
}
