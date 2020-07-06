package ru.kalashnikov.example.auction.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BetDto  {
    private Long id;

    private BigDecimal amount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime initTime;

    private Long itemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getInitTime() {
        return initTime;
    }

    public void setInitTime(LocalDateTime initTime) {
        this.initTime = initTime;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
