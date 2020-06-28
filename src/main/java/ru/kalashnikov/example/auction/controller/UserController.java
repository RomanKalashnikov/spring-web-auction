package ru.kalashnikov.example.auction.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;
import ru.kalashnikov.example.auction.entity.User;
import ru.kalashnikov.example.auction.DTO.UserDto;
import ru.kalashnikov.example.auction.mapper.UserMapper;
import ru.kalashnikov.example.auction.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserRepository repository;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @GetMapping
    private List<UserDto> getAllUsers() {
        List<User> repositoryAll = (List<User>) repository.findAll();

        log.info("ReposResp {}", repositoryAll);
        return userMapper.toDTOList(repositoryAll);
    }

    @PostMapping
    private UserDto create(@RequestBody UserDto userDto) {
        log.info("Bet {}", userDto);
        User s = userMapper.toDomain(userDto);
        repository.save(s);
        return userMapper.toDTO(s);
    }

    @GetMapping("/{id}")
    private UserDto getUser(@PathVariable("id") Long id) {
        Optional<User> byId = repository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }

        return userMapper.toDTO(byId.get());
    }



}
