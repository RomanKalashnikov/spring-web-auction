package ru.kalashnikov.example.auction.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USR")
public class User {
    @Id
    @GeneratedValue(generator = "GENERATOR_ID")
    private Long id;
    @Column(nullable = false)
    private String name;
    // TODO имя адрес, возраст, пол,  отдельлный класс Bet как сущность.
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private int age;

}
