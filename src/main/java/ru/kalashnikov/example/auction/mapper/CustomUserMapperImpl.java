package ru.kalashnikov.example.auction.mapper;

import org.springframework.stereotype.Component;
import ru.kalashnikov.example.auction.dto.UserDto;
import ru.kalashnikov.example.auction.entity.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserMapperImpl implements CustomMapper<User, UserDto> {


    @Override
    public User toDomain(UserDto userDto) {
        if (userDto == null) {
            return new User();
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setAge(userDto.getAge());
        return user;
    }

    @Override
    public UserDto toDTO(User domain) {
        if (domain == null) {
            return new UserDto();
        }
        UserDto userDto = new UserDto();
        userDto.setAge(domain.getAge());
        userDto.setAddress(domain.getAddress());
        userDto.setName(domain.getName());
        userDto.setId(domain.getId());
        return userDto;
    }

    @Override
    public List<User> toDomainList(List<UserDto> customDtoList) {
        if (customDtoList.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<User> users = new ArrayList<>();
        for (UserDto userDto : customDtoList) {
            users.add(toDomain(userDto));
        }
        return users;
    }

    @Override
    public List<UserDto> toDTOList(List<User> list) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<UserDto> userDtos = new ArrayList<>();
        for (User user : list) {
            userDtos.add(toDTO(user));
        }
        return userDtos;
    }

    @Override
    public User merge(User user, UserDto userDto) {

        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if (userDto.getAddress() != null) {
            user.setAddress(userDto.getAddress());
        }
        if (userDto.getAge() != null) {
            user.setAge(userDto.getAge());
        }
        if(userDto.getAddress() != null){
            user.setAddress(userDto.getAddress());
        }
        return user;
    }
}
