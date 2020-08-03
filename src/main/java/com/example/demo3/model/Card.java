package com.example.demo3.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Card {


    private int id;

    private String holderName;


    private double balance;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date expirationDate;


    private String number;


}