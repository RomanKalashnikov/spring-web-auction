package ru.kalashnikov.example.auction.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USR")
@Data
public class User {
    @Id
    @GeneratedValue(generator = "GENERATOR_ID")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Integer age;

}
