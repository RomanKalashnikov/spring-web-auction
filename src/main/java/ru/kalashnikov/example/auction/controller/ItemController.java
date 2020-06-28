package ru.kalashnikov.example.auction.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;
import ru.kalashnikov.example.auction.DTO.ItemDto;
import ru.kalashnikov.example.auction.entity.Item;
import ru.kalashnikov.example.auction.entity.User;
import ru.kalashnikov.example.auction.mapper.ItemMapper;
import ru.kalashnikov.example.auction.repository.ItemRepository;
import ru.kalashnikov.example.auction.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

    @GetMapping
    private List<ItemDto> getAllBet() {
        List<Item> repositoryAllItem = (List<Item>) itemRepository.findAll();

        log.info("ReposResp {}", repositoryAllItem);
        return itemMapper.toDTOList(repositoryAllItem);
    }

    @PostMapping
    private ItemDto create(@RequestBody ItemDto itemDto) {
        log.info("Item {}", itemDto);
        Optional<User> seller = userRepository.findById(itemDto.getSellerId());
        if (seller.isEmpty()) {
            throw new RuntimeException("нет продавца");
        }

        Item s = itemMapper.toDomain(itemDto);
        s.setSeller(seller.get());
        itemRepository.save(s);
        return itemMapper.toDTO(s);
    }

    @GetMapping("/{item}")
    private ItemDto getItem(@PathVariable("id") Long id) {
        Optional<Item> itemById = itemRepository.findById(id);
        if (itemById.isEmpty()) {
            return null;
        }
        return itemMapper.toDTO(itemById.get());

    }

}
