package ru.kalashnikov.example.auction.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.kalashnikov.example.auction.DTO.BetDto;
import ru.kalashnikov.example.auction.entity.Bet;
import ru.kalashnikov.example.auction.entity.Item;
import ru.kalashnikov.example.auction.mapper.BetMapper;
import ru.kalashnikov.example.auction.repository.BetRepository;
import ru.kalashnikov.example.auction.repository.ItemRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bets")
@RequiredArgsConstructor
@Slf4j
public class BetController {
    private final BetRepository betRepository;
    private final ItemRepository itemRepository;
    private final BetMapper betMapper = Mappers.getMapper(BetMapper.class);

    @GetMapping
    private List<BetDto> getAllBet() {
        List<Bet> repositoryAll = (List<Bet>) betRepository.findAll();

        log.info("ReposResp {}", repositoryAll);
        return betMapper.toDTOList(repositoryAll);
    }

    @PostMapping
    private BetDto create(@RequestBody BetDto betDto) {
        log.info("Bet {}", betDto);
        Bet newBet = betMapper.toDomain(betDto);
        Optional<Item> it = itemRepository.findById(betDto.getItemId());
        if (it.isEmpty()) {
            throw new RuntimeException("предмета не существует");
        }
        Item item = it.get();

        Bet currentBet = item.getCurrentBet();
        if(currentBet != null){
            BigDecimal amount = currentBet.getAmount();
            if (newBet.getAmount().compareTo(amount) != 1) {
                throw new RuntimeException("ставка меньше текущей");
            }
        }
        //TODO проверить время завешения торго лота > чем мы пытаемся поставить и обновить время ставки на этом Bet. и блять сделать как же там сервер рассчитвает время .
        newBet.setInitTime(LocalDateTime.now());
        item.setCurrentBet(newBet);
        betRepository.save(newBet);
        return betMapper.toDTO(newBet);
    }

    @GetMapping("/{bet}")
    private BetDto getBet(@PathVariable("id") Long id) {
        Optional<Bet> byId = betRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        return betMapper.toDTO(byId.get());
    }


}
