package com.example.demo3.contr;

import com.example.demo3.configs.SecurityContextProvider;
import com.example.demo3.model.oauth.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@Log4j2
@RestController
@RequestMapping("/api/test")
public class TestController1 {

    @Autowired
    private SecurityContextProvider securityContextProvider;

    @GetMapping
    public ResponseEntity test(OAuth2Authentication oAuth2Authentication4) {
        User user = securityContextProvider.getByAuthentication(oAuth2Authentication4);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/t2")
    public ResponseEntity test2(OAuth2Authentication oAuth2Authentication4) {
        return ResponseEntity.ok(oAuth2Authentication4);
    }
}
