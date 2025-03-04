package exate.com.security.oauth;

import com.fasterxml.jackson.core.JsonProcessingException;
import exate.com.security.oauth.google.GoogleOauthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/auth")
public class OauthController {
    private final OauthService oauthService;

    @GetMapping("/google")
    public String login() {
        return oauthService.request();
    }

    @GetMapping("/token")
    public GoogleOauthResponse token(@RequestParam("code") String code) throws JsonProcessingException {
        System.out.println(code);
        return oauthService.accessToken(code);
    }
}
