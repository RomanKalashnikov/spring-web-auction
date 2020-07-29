package ru.kalashnikov.example.auction.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kalashnikov.example.auction.dto.ItemDto;
import ru.kalashnikov.example.auction.entity.Item;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ItemMapper {
    Item create(Long sellerId, String name, BigDecimal initPrice, LocalDateTime biddingStartTime, Integer biddingPeriod);

    Item toDomain(ItemDto dto);

    ItemDto toDTO(Item domain);

    List<Item> toDomainList(List<ItemDto> customDtoList);

    List<ItemDto> toDTOList(List<Item> list);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "initPrice", source = "dto.initPrice")
    @Mapping(target = "biddingStartTime", source = "dto.biddingStartTime")
    @Mapping(target = "biddingPeriod", source = "dto.biddingPeriod")
    @Mapping(target = "completionTime", source = "dto.completionTime")
    @Mapping(target = "currentBet", source = "dto.currentBet")
    Item merge(Item domain, ItemDto dto);
}
