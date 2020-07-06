package ru.kalashnikov.example.auction.mapper;

import ru.kalashnikov.example.auction.dto.UserDto;
import ru.kalashnikov.example.auction.entity.User;

import java.util.List;
public interface CustomMapper<Domain, Dto> {
    Domain toDomain(Dto dto);

    Dto toDTO(Domain domain);

    List<Domain> toDomainList(List<Dto> customDtoList);

    List<Dto> toDTOList(List<Domain> list);

    Domain merge (Domain domain, Dto dto);
}
