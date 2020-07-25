package ru.kalashnikov.example.auction.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ru.kalashnikov.example.auction.entity.Bet;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data

public class ItemDto {
    private Long id;

    private Long sellerId;

    private String name;

    private BigDecimal initPrice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime biddingStartTime;

    private Integer biddingPeriod;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completionTime;

    private Bet currentBet;


}
