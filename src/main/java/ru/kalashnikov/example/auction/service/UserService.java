package ru.kalashnikov.example.auction.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kalashnikov.example.auction.dto.UserDto;
import ru.kalashnikov.example.auction.entity.User;
import ru.kalashnikov.example.auction.mapper.CustomMapper;
import ru.kalashnikov.example.auction.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class UserService implements CustomService {
    private final UserRepository repository;

    private final CustomMapper<User,UserDto> userMapper ;

//    public UserService(UserRepository repository, CustomMapper<User, UserDto> userMapper) {
//        this.repository = repository;
//        this.userMapper = userMapper;
//    }

    public List<UserDto> getAllUser() {
        List<User> repositoryAll = (List<User>) repository.findAll();
        return userMapper.toDTOList(repositoryAll);
    }

    public UserDto create(UserDto userDto) {
        User user = userMapper.toDomain(userDto);
        repository.save(user);

        return userMapper.toDTO(user);
    }
    public UserDto create(String name,String address, Integer age) {

        User user = userMapper.toDomainWithParam(name,address,age);
        repository.save(user);

        return userMapper.toDTO(user);
    }
    public UserDto getUser(Long id) {
        Optional<User> byId = repository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }

        return userMapper.toDTO(byId.get());
    }
    public UserDto update(Long id ,UserDto userDto){
        Optional<User> byId = repository.findById(id);
        if(byId.isEmpty()){
            throw new RuntimeException("Данного пользователя нет");
        }
        User oldUser = byId.get();

        User merge = userMapper.merge(oldUser, userDto);
        repository.save(merge);
        return userMapper.toDTO(merge);

    }
}
