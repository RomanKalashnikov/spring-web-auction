package ru.kalashnikov.example.auction.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ru.kalashnikov.example.auction.dto.ItemDto;
import ru.kalashnikov.example.auction.entity.Item;
import ru.kalashnikov.example.auction.entity.User;
import ru.kalashnikov.example.auction.mapper.CustomMapper;
import ru.kalashnikov.example.auction.mapper.ItemMapper;
import ru.kalashnikov.example.auction.repository.ItemRepository;
import ru.kalashnikov.example.auction.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class ItemService implements CustomService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);
//    public ItemService(ItemRepository itemRepository, UserRepository userRepository, CustomMapper<Item, ItemDto> itemMapper) {
//        this.itemRepository = itemRepository;
//        this.userRepository = userRepository;
//        this.itemMapper = itemMapper;
//    }

    public List<ItemDto> getAllBet() {
        List<Item> repositoryAllItem = (List<Item>) itemRepository.findAll();
        log.info("ReposResp {}", repositoryAllItem);
        return itemMapper.toDTOList(repositoryAllItem);
    }

    public ItemDto create(ItemDto itemDto) {
        log.info("Выполняется метод Create() c DTO {}", itemDto);
        Optional<User> seller = userRepository.findById(itemDto.getSellerId());
        if (seller.isEmpty()) {
            throw new RuntimeException("нет продавца");
        }
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dateTime = LocalDateTime.parse(itemDto.getBiddingStartTime().toString(), formatter);

        Item item = itemMapper.toDomain(itemDto);
        item.setSeller(seller.get());
        item.setCompletionTime(itemDto.getBiddingStartTime().plusDays(itemDto.getBiddingPeriod()));
        itemRepository.save(item);
        return itemMapper.toDTO(item);
    }

    public ItemDto getItem(Long id) {
        Optional<Item> itemById = itemRepository.findById(id);
        if (itemById.isEmpty()) {
            throw new RuntimeException("Нет предмета с id " + id);
        }
        return itemMapper.toDTO(itemById.get());

    }

    public ItemDto create(Long sellerId, String name, BigDecimal initPrice, String  biddingStartTime, Integer biddingPeriod) {
        Optional<User> seller = userRepository.findById(sellerId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(biddingStartTime, formatter);

        if (seller.isEmpty()) {
            throw new RuntimeException("нет продавца");
        }

        Item item = itemMapper.create(sellerId, name, initPrice, dateTime, biddingPeriod);
        item.setSeller(seller.get());
        item.setCompletionTime(dateTime.plusDays(biddingPeriod));
        itemRepository.save(item);

        return itemMapper.toDTO(item);
    }
}
