//package ru.kalashnikov.example.auction.mapper;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import ru.kalashnikov.example.auction.dto.ItemDto;
//import ru.kalashnikov.example.auction.entity.Item;
//import ru.kalashnikov.example.auction.entity.User;
//import ru.kalashnikov.example.auction.mapper.CustomItemMapperImpl;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ItemMapperTest {
//    private final CustomMapper<Item, ItemDto> itemMapper = new CustomItemMapperImpl();
//
//    @Test
//    void toDomain() {
//        ItemDto itemDto = new ItemDto();
//        itemDto.setInitPrice(BigDecimal.valueOf(100));
//        itemDto.setName("Glass");
//        itemDto.setBiddingPeriod(5);
//
//        Item item = itemMapper.toDomain(itemDto);
//
//        assertEquals(item.getName(), itemDto.getName());
//        assertEquals(item.getInitPrice(), itemDto.getInitPrice());
//        assertEquals(item.getBiddingPeriod(), itemDto.getBiddingPeriod());
//    }
//
//    @Test
//    void toDTO() {
//        Item item = new Item();
//        item.setCompletionTime(LocalDateTime.now());
//        item.setName("Car");
//        item.setInitPrice(BigDecimal.valueOf(1800));
//        item.setId((long) 25);
//        item.setBiddingStartTime(LocalDateTime.now());
//        item.setBiddingPeriod(7);
//
//        User user = new User();
//        user.setId((long) 1);
//
//        item.setSeller(user);
//        ItemDto itemDto = itemMapper.toDTO(item);
//
//        assertEquals(itemDto.getCompletionTime(),item.getCompletionTime());
//        assertEquals(itemDto.getName(),item.getName());
//        assertEquals(itemDto.getInitPrice(),item.getInitPrice());
//        assertEquals(itemDto.getId(),item.getId());
//        assertEquals(itemDto.getBiddingStartTime(),item.getBiddingStartTime());
//        assertEquals(itemDto.getBiddingPeriod(),item.getBiddingPeriod());
//
//    }
//
//    @Test
//    void toDomainList() {
//        List<Item> nullItemList = itemMapper.toDomainList(null);
//        assertNotNull(nullItemList);
//        List<Item> newItemList = itemMapper.toDomainList(new ArrayList<>());
//        assertNotNull(newItemList);
//    }
//
//    @Test
//    void toDTOList() {
//        List<ItemDto> nullItemDtoList = itemMapper.toDTOList(null);
//        assertNotNull(nullItemDtoList);
//        List<ItemDto> newItemDtoList = itemMapper.toDTOList(new ArrayList<>());
//        assertNotNull(newItemDtoList);
//    }
//
//    @Test
//    void mergeBiddingPeriod() {
//        ItemDto itemDto = new ItemDto();
//        itemDto.setBiddingPeriod(5);
//        Item item = new Item();
//        itemMapper.merge(item, itemDto);
//        assertNotNull(item.getBiddingPeriod());
//        assertEquals(item.getBiddingPeriod(), itemDto.getBiddingPeriod());
//    }
//
//    @Test
//    void mergeBiddingStartTime() {
//        ItemDto itemDto = new ItemDto();
//        itemDto.setBiddingStartTime(LocalDateTime.now());
//        Item item = new Item();
//        itemMapper.merge(item, itemDto);
//        assertNotNull(item.getBiddingStartTime());
//        assertEquals(item.getBiddingStartTime(), itemDto.getBiddingStartTime());
//    }
//
//    @Test
//    void mergeCompletionTime() {
//        ItemDto itemDto = new ItemDto();
//        itemDto.setCompletionTime(LocalDateTime.now());
//        Item item = new Item();
//        itemMapper.merge(item, itemDto);
//        assertNotNull(item.getCompletionTime());
//        assertEquals(item.getCompletionTime(), itemDto.getCompletionTime());
//    }
//
//    @Test
//    void mergeId() {
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId((long) 7);
//        Item item = new Item();
//        itemMapper.merge(item, itemDto);
//        assertNotNull(item.getId());
//        assertEquals(item.getId(), itemDto.getId());
//    }
//
//    @Test
//    void mergeInitPrice() {
//        ItemDto itemDto = new ItemDto();
//        itemDto.setInitPrice(BigDecimal.valueOf(2500));
//        Item item = new Item();
//        itemMapper.merge(item, itemDto);
//        assertNotNull(item.getInitPrice());
//        assertEquals(item.getInitPrice(), itemDto.getInitPrice());
//    }
//
//    @Test
//    void mergeName() {
//        ItemDto itemDto = new ItemDto();
//        itemDto.setName("Picture");
//        Item item = new Item();
//        itemMapper.merge(item, itemDto);
//        assertNotNull(item.getName());
//        assertEquals(item.getName(), itemDto.getName());
//    }
//
//
//
//}