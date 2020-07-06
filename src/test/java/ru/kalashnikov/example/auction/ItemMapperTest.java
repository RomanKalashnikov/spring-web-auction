package ru.kalashnikov.example.auction;

import com.sun.xml.bind.v2.model.core.ID;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kalashnikov.example.auction.dto.ItemDto;
import ru.kalashnikov.example.auction.entity.Item;
import ru.kalashnikov.example.auction.entity.User;
import ru.kalashnikov.example.auction.mapper.CustomItemMapperImpl;
import ru.kalashnikov.example.auction.mapper.CustomMapper;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ItemMapperTest {
    private final CustomMapper<Item, ItemDto> itemMapper = new CustomItemMapperImpl();

    @Test
    void toDomain() {
        ItemDto itemDto = new ItemDto();
        itemDto.setInitPrice(BigDecimal.valueOf(100));
        itemDto.setName("Glass");
        itemDto.setSellerId((long) 12);
        itemDto.setBiddingPeriod(5);
        Item item = itemMapper.toDomain(itemDto);

        User user = new User();
        user.setId((long) 12);
        item.setSeller(user);

        assertEquals(item.getName(),itemDto.getName());
        assertEquals(item.getInitPrice(),itemDto.getInitPrice());
        assertEquals(item.getSeller().getId(),itemDto.getSellerId());
        assertEquals(item.getBiddingPeriod(),itemDto.getBiddingPeriod());
    }

    @Test
    void toDTO() {

    }

    @Test
    void toDomainList() {
    }

    @Test
    void toDTOList() {
    }

    @Test
    void merge() {
    }
}