package ru.kalashnikov.example.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kalashnikov.example.auction.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByGuestname(String name);
}
