package com.example.demo3.service.abst;

import com.example.demo3.model.my.ShoppingStore;
import com.example.demo3.model.oauth.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.transaction.Transactional;
import java.util.List;

public interface StoreService {


    List<ShoppingStore> getStores(int userId);

    @Transactional
    void addStore(ShoppingStore store, User user);
}
