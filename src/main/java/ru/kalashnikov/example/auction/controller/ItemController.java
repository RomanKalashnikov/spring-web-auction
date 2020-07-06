package ru.kalashnikov.example.auction.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.kalashnikov.example.auction.dto.ItemDto;
import ru.kalashnikov.example.auction.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/items")
@Slf4j
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    private List<ItemDto> getAllBet() {
        return  itemService.getAllBet();
    }

    @PostMapping
    private ItemDto create(@RequestBody ItemDto itemDto) {
        log.info("Item {}", itemDto);
        return itemService.create(itemDto);
    }

    @GetMapping("/{item}")
    private ItemDto getItem(@PathVariable("id") Long id) {
       return itemService.getItem(id);

    }

}
