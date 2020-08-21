package com.example.demo3.respository;

import com.example.demo3.model.my.ShoppingStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<ShoppingStore, Integer> {

    ShoppingStore getById(int id);

    List<ShoppingStore> getByUserId(int id);
}
