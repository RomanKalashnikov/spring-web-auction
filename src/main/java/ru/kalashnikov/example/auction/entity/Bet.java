package ru.kalashnikov.example.auction.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cglib.core.GeneratorStrategy;
import org.springframework.cglib.proxy.Mixin;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Stack;

@Entity
@Table(name = "BET")
@Data
@NoArgsConstructor
public class Bet {

    public Bet(BigDecimal amount, Item item) {
        this.amount = amount;
        this.item = item;
    }

    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
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
