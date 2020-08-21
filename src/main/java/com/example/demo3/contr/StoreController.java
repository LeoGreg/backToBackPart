package com.example.demo3.contr;


import com.example.demo3.configs.SecurityContextProvider;
import com.example.demo3.model.my.ShoppingStore;
import com.example.demo3.model.oauth.User;
import com.example.demo3.service.abst.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/shopping")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private SecurityContextProvider securityContextProvider;

    @GetMapping("/get")
    public ResponseEntity getAll(OAuth2Authentication oAuth2Authentication) {
        User user = securityContextProvider.getByAuthentication(oAuth2Authentication);
        return ResponseEntity.ok(storeService.getStores(user.getId()));
    }

    @PostMapping("/add")
    public ResponseEntity save(@Valid @RequestBody ShoppingStore store, OAuth2Authentication oAuth2Authentication) {
        User user = securityContextProvider.getByAuthentication(oAuth2Authentication);
        storeService.addStore(store, user);
        return ResponseEntity.ok(store);
    }
}
