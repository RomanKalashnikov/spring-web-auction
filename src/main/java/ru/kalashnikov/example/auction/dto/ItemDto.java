package ru.kalashnikov.example.auction.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.kalashnikov.example.auction.entity.Bet;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInitPrice() {
        return initPrice;
    }

    public void setInitPrice(BigDecimal initPrice) {
        this.initPrice = initPrice;
    }

    public LocalDateTime getBiddingStartTime() {
        return biddingStartTime;
    }

    public void setBiddingStartTime(LocalDateTime biddingStartTime) {
        this.biddingStartTime = biddingStartTime;
    }

    public Integer getBiddingPeriod() {
        return biddingPeriod;
    }

    public void setBiddingPeriod(Integer biddingPeriod) {
        this.biddingPeriod = biddingPeriod;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    public Bet getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(Bet currentBet) {
        this.currentBet = currentBet;
    }
}
