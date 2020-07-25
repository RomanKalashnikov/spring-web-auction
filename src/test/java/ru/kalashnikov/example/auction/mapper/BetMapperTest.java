//package ru.kalashnikov.example.auction.mapper;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import ru.kalashnikov.example.auction.dto.BetDto;
//import ru.kalashnikov.example.auction.entity.Bet;
//import ru.kalashnikov.example.auction.entity.Item;
//import ru.kalashnikov.example.auction.mapper.CustomBetMapperImpl;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class BetMapperTest {
//    private final CustomMapper<Bet, BetDto> betMapper = new CustomBetMapperImpl();
//
//    @Test
//    void testFullToDomain() {
//        BetDto betDto = new BetDto();
//        betDto.setId((long) 1);
//        betDto.setAmount(BigDecimal.valueOf(56));
//        betDto.setItemId((long) 1);
//        betDto.setInitTime(LocalDateTime.now());
//
//        Bet bet = betMapper.toDomain(betDto);
//
//        assertEquals(bet.getBetId(), betDto.getId());
//        assertEquals(bet.getAmount(), betDto.getAmount());
//        assertEquals(bet.getBetId(), betDto.getItemId());
//        assertEquals(bet.getInitTime(), betDto.getInitTime());
//    }
//    @Test
//    void testNotNullToDomain(){
//        Bet bet = betMapper.toDomain(null);
//        assertNotNull(bet);
//    }
//    @Test
//    void testFullToDTO() {
//        Bet bet = new Bet();
//        bet.setAmount(BigDecimal.valueOf(15));
//        bet.setBetId((long) 56);
//        bet.setInitTime(LocalDateTime.now());
//        Item item = new Item();
//        item.setId((long) 45);
//        bet.setItem(item);
//
//        BetDto betDto = betMapper.toDTO(bet);
//
//        assertEquals(betDto.getId(),bet.getBetId());
//        assertEquals(betDto.getInitTime(),bet.getInitTime());
//        assertEquals(betDto.getAmount(), bet.getAmount());
//    }
//    @Test
//    void notNullToDto(){
//        BetDto betDto = betMapper.toDTO(null);
//        assertNotNull(betDto);
//    }
//
//    @Test
//    void toDomainList() {
//        List<Bet> nullBetList = betMapper.toDomainList(null);
//        assertNotNull(nullBetList);
//        List<Bet> newBetList = betMapper.toDomainList(new ArrayList<>());
//        assertNotNull(newBetList);
//    }
//
//    @Test
//    void toDTOList() {
//        List<BetDto> nullBetDtoList = betMapper.toDTOList(null);
//        assertNotNull(nullBetDtoList);
//        List<BetDto> newBetDtoList = betMapper.toDTOList(new ArrayList<>());
//        assertNotNull(newBetDtoList);
//    }
//
//
//    @Test
//    void testMergeAmount() {
//        BetDto betDto = new BetDto();
//        betDto.setAmount(BigDecimal.valueOf(45));
//        Bet bet = new Bet();
//
//        betMapper.merge(bet, betDto);
//
//        assertEquals(bet.getAmount(), betDto.getAmount());
//    }
//
//    @Test
//    void testMergeId() {
//        BetDto betDto = new BetDto();
//        betDto.setId((long) 12);
//        Bet bet = new Bet();
//
//        betMapper.merge(bet, betDto);
//
//        assertEquals(bet.getBetId(), betDto.getId());
//    }
//
//    @Test
//    void testMergeInitTime() {
//        BetDto betDto = new BetDto();
//        betDto.setInitTime(LocalDateTime.now());
//        Bet bet = new Bet();
//
//        betMapper.merge(bet, betDto);
//
//        assertEquals(bet.getInitTime(), bet.getInitTime());
//    }
//}