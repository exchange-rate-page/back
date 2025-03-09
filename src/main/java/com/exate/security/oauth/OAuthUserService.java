package com.exate.security.oauth;

import com.exate.member.Member;
import com.exate.member.MemberRepository;
import com.exate.security.oauth.oauthserver.GoogleOAuthResponse;
import com.exate.security.oauth.oauthserver.KakaoOAuthResponse;
import com.exate.security.oauth.oauthserver.NaverOAuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class OAuthUserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("loadUser method called");
        OAuth2User oAuth2User = super.loadUser(userRequest);

        OAuthResponse oAuthResponse = getOAuthResponse(userRequest, oAuth2User);
        Assert.notNull(oAuthResponse, "E");

        Member member = Member.builder()
                .name(oAuthResponse.getName())
                .email(oAuthResponse.getEmail())
                .picture(oAuthResponse.getPicture())
                .oAuthServer(oAuthResponse.getProvider())
                .build();

        Member savedMember = memberRepository.save(member);

        return new CustomOAuthUser(savedMember);
    }

    private OAuthResponse getOAuthResponse(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        if(registrationId.equals("google")) {
            return new GoogleOAuthResponse(oAuth2User.getAttributes());
        }
        if(registrationId.equals("naver")) {
            return new NaverOAuthResponse(oAuth2User.getAttributes());
        }
        if(registrationId.equals("kakao")) {
            return new KakaoOAuthResponse(oAuth2User.getAttributes());
        }
        return null;
    }
}
