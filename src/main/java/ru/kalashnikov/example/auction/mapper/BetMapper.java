package ru.kalashnikov.example.auction.mapper;

import org.mapstruct.Mapper;
import ru.kalashnikov.example.auction.DTO.BetDto;
import ru.kalashnikov.example.auction.entity.Bet;

import java.util.List;

@Mapper
public interface BetMapper {
    Bet toDomain(BetDto betDto);

    BetDto toDTO(Bet bet);

    List<Bet> toDomainList(List<BetDto> betDtos);

    List<BetDto> toDTOList(List<Bet> bets);
}
