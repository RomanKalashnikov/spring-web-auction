package ru.kalashnikov.example.auction.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kalashnikov.example.auction.dto.ItemDto;
import ru.kalashnikov.example.auction.service.ItemService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/items")
@Slf4j
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String items(Map<String, Object> model) {
        List<ItemDto> all = itemService.getAllBet();
        model.put("item", all);
        return "items";
    }

    @PostMapping
//    public String add(@RequestParam Long sellerId, @RequestParam String name, @RequestParam BigDecimal initPrice, @RequestParam String  biddingStartTime,
//                      Integer biddingPeriod, Map<String, Object> model) {
    public String add(  ItemDto itemDto, Map<String, Object> model) {

//        itemService.create(sellerId, name, initPrice, biddingStartTime, biddingPeriod);
        itemService.create(itemDto);

        List<ItemDto> all = itemService.getAllBet();
        model.put("item", all);
        return "items";
    }

//    @GetMapping
//    public List<ItemDto> getAllBet() {
//        return  itemService.getAllBet();
//    }
//
//    @PostMapping
//    public ItemDto create(@RequestBody ItemDto itemDto) {
//        log.info("Item {}", itemDto);
//        return itemService.create(itemDto);
//    }
//
//    @GetMapping("/{item}")
//    public ItemDto getItem(@PathVariable("id") Long id) {
//       return itemService.getItem(id);
//
//    }

}
