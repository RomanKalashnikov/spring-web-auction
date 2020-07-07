package ru.kalashnikov.example.auction.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.kalashnikov.example.auction.dto.UserDto;
import ru.kalashnikov.example.auction.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private List<UserDto> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping
    private UserDto create(@RequestBody UserDto userDto) {
        log.info("Bet {}", userDto);
        return userService.create(userDto);
    }

    @GetMapping("/{id}")
    private UserDto getUser(@PathVariable("id") Long id) {
        log.info("User id {}", id);
        return userService.getUser(id);
    }

    @PostMapping("/{id}")
    private UserDto update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        log.info("Update User {} from {}", id, userDto);
        return userService.update(id,userDto);
    }


}
