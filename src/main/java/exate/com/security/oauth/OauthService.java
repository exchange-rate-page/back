package exate.com.security.oauth;

import com.fasterxml.jackson.core.JsonProcessingException;
import exate.com.security.oauth.google.GoogleOauth;
import exate.com.security.oauth.google.GoogleOauthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OauthService {

    private final GoogleOauth googleOauth;

    public String request() {
        return googleOauth.getOauthRedirectURL();
    }

    public GoogleOauthResponse accessToken(String code) throws JsonProcessingException {
        return googleOauth.requestAccessToken(code);
    }
}
