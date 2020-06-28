package ru.kalashnikov.example.auction.mapper;

import org.mapstruct.Mapper;
import ru.kalashnikov.example.auction.DTO.ItemDto;
import ru.kalashnikov.example.auction.entity.Item;

import java.util.List;

@Mapper
public interface ItemMapper {
    Item toDomain(ItemDto item);

    ItemDto toDTO(Item item);

    List<Item> toDomainList(List<ItemDto> itemDtos);

    List<ItemDto> toDTOList(List<Item> items);
}
