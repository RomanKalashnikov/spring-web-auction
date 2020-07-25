package ru.kalashnikov.example.auction.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "BET")
@Data
public class Bet {
//    @ToString.Exclude
    @Id
    @GeneratedValue(generator = "GENERATOR_ID")
    @Column(name = "betId")
    private Long betId;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime initTime;

    @OneToOne
    @ToString.Exclude
    private Item item;

}
