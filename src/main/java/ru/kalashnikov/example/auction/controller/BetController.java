package ru.kalashnikov.example.auction.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.kalashnikov.example.auction.dto.BetDto;
import ru.kalashnikov.example.auction.service.BetService;

import java.util.List;

@RestController
@RequestMapping("/bets")
@Slf4j
public class BetController {
    private final BetService betService;

    public BetController(BetService betService) {
        this.betService = betService;
    }

    @GetMapping
    public List<BetDto> getAllBet() {
        return betService.getAllBet();
    }

    @PostMapping
    public BetDto create(@RequestBody BetDto betDto) {
        return betService.create(betDto);
    }

    @GetMapping("/{id}")
    public BetDto getBet(@PathVariable("id") Long id) {
        return betService.getBet(id);
    }


}
