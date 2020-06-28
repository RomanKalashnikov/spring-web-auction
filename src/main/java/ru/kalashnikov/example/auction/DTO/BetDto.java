package ru.kalashnikov.example.auction.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BetDto {
    private Long id;

    private BigDecimal amount;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime initTime;
    private Long itemId;
}
