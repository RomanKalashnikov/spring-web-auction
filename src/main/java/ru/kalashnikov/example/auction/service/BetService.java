package ru.kalashnikov.example.auction.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ru.kalashnikov.example.auction.dto.BetDto;
import ru.kalashnikov.example.auction.entity.Bet;
import ru.kalashnikov.example.auction.entity.Item;
import ru.kalashnikov.example.auction.mapper.CustomMapper;
import ru.kalashnikov.example.auction.repository.BetRepository;
import ru.kalashnikov.example.auction.repository.ItemRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class BetService implements CustomService {
    private final BetRepository betRepository;
    private final ItemRepository itemRepository;

    private final CustomMapper<Bet, BetDto> betMapper;

    public BetService(BetRepository betRepository, ItemRepository itemRepository, CustomMapper<Bet, BetDto> betMapper) {
        this.betRepository = betRepository;
        this.itemRepository = itemRepository;
        this.betMapper = betMapper;
    }

    public List<BetDto> getAllBet() {
        List<Bet> repositoryAll = (List<Bet>) betRepository.findAll();

        log.info("ReposResp {}", repositoryAll);
        return betMapper.toDTOList(repositoryAll);
    }

    public BetDto create( BetDto betDto) {
        log.info("Bet {}", betDto);
        Bet newBet = betMapper.toDomain(betDto);
        Optional<Item> it = itemRepository.findById(betDto.getItemId());
        if (it.isEmpty()) {
            throw new RuntimeException("предмета не существует");
        }
        Item item = it.get();

        Bet currentBet = item.getCurrentBet();
        if (currentBet != null) {
            BigDecimal amount = currentBet.getAmount();
            if (newBet.getAmount().compareTo(amount) != 1) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR , "ставка меньше текущей", new Exception("ставка меньше текущей"));
            }
        }

        if (LocalDateTime.now().isAfter(item.getCompletionTime())) {
            throw new RuntimeException("Вы опоздали. Торги уже завершены");
        }

        newBet.setInitTime(LocalDateTime.now());

        newBet.setItem(item);
        item.setCurrentBet(newBet);
        betRepository.save(newBet);
        return betMapper.toDTO(newBet);
    }

    public BetDto getBet(Long id) {
        Optional<Bet> byId = betRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        return betMapper.toDTO(byId.get());
    }


}
