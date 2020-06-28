package ru.kalashnikov.example.auction.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kalashnikov.example.auction.entity.Item;

public interface ItemRepository  extends CrudRepository<Item, Long> {
}
