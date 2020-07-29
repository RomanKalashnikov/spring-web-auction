package ru.kalashnikov.example.auction.controller;

import ru.kalashnikov.example.auction.entity.Guest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String text;
    private Guest guest;


    public Message() {

    }
}
