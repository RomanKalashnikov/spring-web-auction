package ru.kalashnikov.example.auction.mapper;

import org.springframework.stereotype.Component;
import ru.kalashnikov.example.auction.dto.BetDto;
import ru.kalashnikov.example.auction.entity.Bet;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomBetMapperImpl implements CustomMapper<Bet, BetDto> {
    @Override
    public Bet toDomain(BetDto betDto) {
        if(betDto == null){
            return new Bet();
        }
        Bet bet = new Bet();
        bet.setBetId(betDto.getId());
        bet.setInitTime(betDto.getInitTime());
        bet.setAmount(betDto.getAmount());
        return  bet;
    }

    @Override
    public BetDto toDTO(Bet bet) {
        if(bet == null){
            return new BetDto();
        }
        BetDto betDto = new BetDto();
        betDto.setAmount(bet.getAmount());
        betDto.setInitTime(bet.getInitTime());
        betDto.setId(bet.getBetId());
        betDto.setItemId(bet.getItem().getId());

        return betDto;
    }

    @Override
    public List<Bet> toDomainList(List<BetDto> customDtoList) {
        if(customDtoList.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Bet> bets = new ArrayList<>();
        for (BetDto betDto : customDtoList) {
            bets.add(toDomain(betDto));
        }
        return bets;
    }

    @Override
    public List<BetDto> toDTOList(List<Bet> list) {
        if(list.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<BetDto> betDtos = new ArrayList<>();
        for (Bet bet : list) {
            betDtos.add(toDTO(bet));
        }
        return betDtos;
    }

    @Override
    public Bet merge(Bet bet, BetDto betDto) {
        if(betDto.getAmount()!=null){
            bet.setAmount(betDto.getAmount());
        }
        if(betDto.getId()!=null){
            bet.setBetId(betDto.getId());
        }
        if(betDto.getInitTime()!=null){
            bet.setInitTime(betDto.getInitTime());
        }
        return bet;
    }
}
