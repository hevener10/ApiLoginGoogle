package com.example.google.login;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @GetMapping("/login")
    public Map<String, Object> currentUser(OAuth2AuthenticationToken authentication) {
        return authentication.getPrincipal().getAttributes();
    }

}
