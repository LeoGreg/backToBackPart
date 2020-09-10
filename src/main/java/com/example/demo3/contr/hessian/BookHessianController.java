package com.example.demo3.contr.hessian;

import com.example.demo.model.hessian.Book;
import com.example.demo3.service.hessianService.BookService;
import com.example.demo3.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hessian")
public class BookHessianController {


    @Autowired
    private BookService bookService;


    @GetMapping
    public ResponseEntity get(@RequestParam int id) throws NotFoundException {
        Book book = bookService.byId(id);
        return ResponseEntity.ok(book);
    }
}