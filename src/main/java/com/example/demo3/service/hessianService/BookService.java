package com.example.demo3.service.hessianService;

import com.example.demo.model.hessian.Book;
import com.example.demo3.util.NotFoundException;

public interface BookService {

    Book save(Book book);


    Book byId(int id)throws NotFoundException;

    Book byName(String name);
}