package ru.kalashnikov.example.auction.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ITEM")

@Data
public class Item {
    @Id
    @GeneratedValue(generator = "GENERATOR_ID")
    @Column(name = "id")
    private Long id;
    private String name;
    @ManyToOne
    @Generated()
    private User seller;

    @Column(nullable = false)
    private BigDecimal initPrice;

    private LocalDateTime biddingStartTime;

    private Integer biddingPeriod;

    private LocalDateTime completionTime;

    @OneToOne(mappedBy = "item", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Bet currentBet;


}

