package ru.kalashnikov.example.auction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kalashnikov.example.auction.entity.Bet;

@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {
}
