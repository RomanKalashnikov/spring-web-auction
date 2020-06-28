package ru.kalashnikov.example.auction.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "BET")
public class Bet {
    @Id
    @GeneratedValue(generator = "GENERATOR_ID")
    Long betId;
    @Column(nullable = false)
    BigDecimal amount;
    @Column(nullable = false)
    LocalDateTime initTime;

}
