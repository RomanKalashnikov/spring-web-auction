package ru.kalashnikov.example.auction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kalashnikov.example.auction.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
