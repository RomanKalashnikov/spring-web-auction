package ru.kalashnikov.example.auction.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kalashnikov.example.auction.dto.BetDto;
import ru.kalashnikov.example.auction.entity.Bet;
import ru.kalashnikov.example.auction.entity.Item;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface BetMapper {
    @Mapping(source = "itemId",target = "item")
    Bet toDomainWithParam(BigDecimal amount, Item itemId);

    Bet toDomain(BetDto dto);

    BetDto toDTO(Bet domain);

    List<Bet> toDomainList(List<BetDto> customDtoList);

    List<BetDto> toDTOList(List<Bet> list);
    @Mapping(source = "dto.amount", target = "amount")
    @Mapping(source = "dto.initTime", target = "initTime")

    Bet merge (Bet domain, BetDto dto);
}
