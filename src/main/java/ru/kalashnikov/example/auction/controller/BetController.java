package ru.kalashnikov.example.auction.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kalashnikov.example.auction.dto.BetDto;
import ru.kalashnikov.example.auction.entity.Bet;
import ru.kalashnikov.example.auction.repository.BetRepository;
import ru.kalashnikov.example.auction.service.BetService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bets")
@Slf4j
public class BetController {
    @Autowired
    private BetService betService;



    //    @GetMapping
//    public List<BetDto> getAllBet() {
//        return betService.getAllBet();
//    }
    @GetMapping
    public String bets(Map<String, Object> model) {
        List<BetDto> all = betService.getAllBet();
        model.put("bet", all);
        return "bets";
    }

    @PostMapping
    public String add(BetDto betDto, Map<String, Object> model) {

        try {
            betService.create(betDto);
        } catch (RuntimeException e) {
            log.error("Предмета нет");
        }
        List<BetDto> all = betService.getAllBet();

        model.put("bet", all);

        return "redirect:/bets";
    }

//    @PostMapping
//    public BetDto create(@RequestBody BetDto betDto) {
//        return betService.create(betDto);
//    }
//
//    @GetMapping("/{id}")
//    public BetDto getBet(@PathVariable("id") Long id) {
//        return betService.getBet(id);
//    }


}
