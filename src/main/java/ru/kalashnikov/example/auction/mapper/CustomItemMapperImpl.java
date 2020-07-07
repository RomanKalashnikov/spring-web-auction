package ru.kalashnikov.example.auction.mapper;

import org.springframework.stereotype.Component;
import ru.kalashnikov.example.auction.dto.ItemDto;
import ru.kalashnikov.example.auction.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomItemMapperImpl implements CustomMapper<Item, ItemDto> {
    @Override
    public Item toDomain(ItemDto itemDto) {
        if (itemDto == null) {
            return new Item();
        }
        Item item = new Item();
        item.setCurrentBet(itemDto.getCurrentBet());
        item.setId(itemDto.getId());
        item.setBiddingPeriod(itemDto.getBiddingPeriod());
        item.setBiddingStartTime(itemDto.getBiddingStartTime());
        item.setCompletionTime(itemDto.getCompletionTime());
        item.setInitPrice(itemDto.getInitPrice());
        item.setName(itemDto.getName());
        return item;
    }

    @Override
    public ItemDto toDTO(Item item) {
        if (item == null) {
            return new ItemDto();
        }
        ItemDto itemDto = new ItemDto();
        itemDto.setBiddingPeriod(item.getBiddingPeriod());
        itemDto.setBiddingStartTime(item.getBiddingStartTime());
        itemDto.setCompletionTime(item.getCompletionTime());
        itemDto.setCurrentBet(item.getCurrentBet());
        itemDto.setId(item.getId());
        itemDto.setInitPrice(item.getInitPrice());
        itemDto.setName(item.getName());
        itemDto.setSellerId(item.getSeller().getId());

        return itemDto;
    }

    @Override
    public List<Item> toDomainList(List<ItemDto> customDtoList) {
        if (customDtoList == null || customDtoList.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Item> items = new ArrayList<>();
        for (ItemDto itemDto : customDtoList) {
            items.add(toDomain(itemDto));
        }
        return items;
    }

    @Override
    public List<ItemDto> toDTOList(List<Item> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : list) {
            itemDtos.add(toDTO(item));
        }
        return itemDtos;
    }

    @Override
    public Item merge(Item item, ItemDto itemDto) {
        if (itemDto.getBiddingPeriod() != null) {
            item.setBiddingPeriod(itemDto.getBiddingPeriod());
        }
        if (itemDto.getBiddingStartTime() != null) {
            item.setBiddingStartTime(itemDto.getBiddingStartTime());
        }
        if (itemDto.getCompletionTime() != null) {
            item.setCompletionTime(itemDto.getCompletionTime());
        }
        if (itemDto.getCurrentBet() != null) {
            item.setCurrentBet(itemDto.getCurrentBet());
        }
        if (itemDto.getId() != null) {
            item.setId(itemDto.getId());
        }
        if (itemDto.getInitPrice() != null) {
            item.setInitPrice(itemDto.getInitPrice());
        }
        if (itemDto.getName() != null) {
            item.setName(itemDto.getName());
        }
        return item;
    }
}














