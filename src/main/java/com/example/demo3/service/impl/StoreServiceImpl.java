package com.example.demo3.service.impl;

import com.example.demo3.configs.SecurityContextProvider;
import com.example.demo3.model.my.ShoppingStore;
import com.example.demo3.model.oauth.User;
import com.example.demo3.respository.StoreRepository;
import com.example.demo3.service.abst.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {


    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<ShoppingStore> getStores(int userId) {
        return storeRepository.getByUserId(userId);
    }

    @Override
    @Transactional
    public void addStore(ShoppingStore store, User user) {
        store.setUserId(user.getId());
        storeRepository.save(store);
    }
}
