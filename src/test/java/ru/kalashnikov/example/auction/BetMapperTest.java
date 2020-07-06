package ru.kalashnikov.example.auction;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kalashnikov.example.auction.dto.BetDto;
import ru.kalashnikov.example.auction.entity.Bet;
import ru.kalashnikov.example.auction.mapper.CustomBetMapperImpl;
import ru.kalashnikov.example.auction.mapper.CustomMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BetMapperTest {
    private final CustomMapper<Bet, BetDto> betMapper = new CustomBetMapperImpl();

    @Test
    void toDomain() {
        BetDto betDto = new BetDto();
        betDto.setId((long) 1);
        betDto.setAmount(BigDecimal.valueOf(56));
        betDto.setItemId((long) 1);
        betDto.setInitTime(LocalDateTime.parse("2020-07-01 12:12:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // TODO loc date time now!
        Bet bet = betMapper.toDomain(betDto);
        assertEquals(bet.getAmount(),betDto.getAmount());
        assertEquals(bet.getBetId(),betDto.getItemId());
        assertEquals(betDto.getInitTime(),bet.getInitTime());
    }

    @Test
    void toDTO() {
        Bet bet = new Bet();
        bet.setAmount(BigDecimal.valueOf(15));
        bet.setBetId((long) 56);
        BetDto betDto = new BetDto();
        betDto.setItemId((long) 56);
        betDto.setAmount(BigDecimal.valueOf(15));
        assertEquals(betDto.getAmount(), bet.getAmount());
    }

    @Test
    void toDomainList() {

    }

    @Test
    void toDTOList() {

    }

    @Test
    void merge() {
        Bet bet = new Bet();
        BigDecimal newAnmount = BigDecimal.valueOf(15);

        BigDecimal oldAmount = BigDecimal.valueOf(45);
        bet.setAmount(oldAmount);

        BetDto betDto = new BetDto();
        betDto.setAmount(newAnmount);

        betMapper.merge(bet,betDto);
        assertEquals(betDto.getAmount(),bet.getAmount());
    }
}