package ru.kalashnikov.example.auction.DTO;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String address;
    private int age;
}
