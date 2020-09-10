package com.example.demo.model.hessian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private int id;

    private String name;

    private int year;
}
