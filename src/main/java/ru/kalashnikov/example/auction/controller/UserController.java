package ru.kalashnikov.example.auction.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kalashnikov.example.auction.dto.UserDto;
import ru.kalashnikov.example.auction.entity.User;
import ru.kalashnikov.example.auction.repository.UserRepository;
import ru.kalashnikov.example.auction.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {
    private UserRepository userRepository;
    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/greetings")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model) {

        model.put("name", name);
        return "Hello " + name;
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        List<UserDto> all = userService.getAllUser();
        model.put("usr", all);
        return "users";
    }


    @PostMapping
    public String add(UserDto userDto, Map<String, Object> model) {

        userService.create(userDto);

        List<UserDto> all = userService.getAllUser();
        model.put("usr", all);
        return "users";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String name, Map<String, Object> model) {
        Iterable<User> users;
        if (name != null && !name.isEmpty()) {
            users = userRepository.findByName(name);

        } else {
            users = userRepository.findAll();
        }
        model.put("usr", users);

        return "users";
    }

}