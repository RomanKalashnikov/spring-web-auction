package ru.kalashnikov.example.auction.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(generator = "GENERATOR_ID")
    Long id;
    String name;
    @ManyToOne
    User seller;

    @Column(nullable = false)
    BigDecimal initPrice;

    LocalDateTime biddingStartTime;

    Integer biddingPeriod;

    LocalDateTime completionTime;
    @OneToOne
    Bet currentBet;

}
