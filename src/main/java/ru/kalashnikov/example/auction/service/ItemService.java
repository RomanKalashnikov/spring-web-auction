package ru.kalashnikov.example.auction.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kalashnikov.example.auction.dto.ItemDto;
import ru.kalashnikov.example.auction.entity.Item;
import ru.kalashnikov.example.auction.entity.User;
import ru.kalashnikov.example.auction.mapper.CustomMapper;
import ru.kalashnikov.example.auction.repository.ItemRepository;
import ru.kalashnikov.example.auction.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class ItemService implements CustomService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final CustomMapper<Item, ItemDto> itemMapper;

    public ItemService(ItemRepository itemRepository, UserRepository userRepository, CustomMapper<Item, ItemDto> itemMapper) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemDto> getAllBet() {
        List<Item> repositoryAllItem = (List<Item>) itemRepository.findAll();
        log.info("ReposResp {}", repositoryAllItem);
        return itemMapper.toDTOList(repositoryAllItem);
    }

    public ItemDto create(ItemDto itemDto) {
        Optional<User> seller = userRepository.findById(itemDto.getSellerId());
        if (seller.isEmpty()) {
            throw new RuntimeException("нет продавца");
        }

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
}
