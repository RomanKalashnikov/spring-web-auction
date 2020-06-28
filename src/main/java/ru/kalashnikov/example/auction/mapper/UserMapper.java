package ru.kalashnikov.example.auction.mapper;

import org.mapstruct.Mapper;
import ru.kalashnikov.example.auction.DTO.UserDto;
import ru.kalashnikov.example.auction.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    User toDomain(UserDto user);

    UserDto toDTO(User user);

    List<User> toDomainList(List<UserDto> user);

    List<UserDto> toDTOList(List<User> user);


}
