package ru.kalashnikov.example.auction.mapper;

import lombok.Data;

import java.util.List;

public interface CustomMapper<Domain, Dto> {
    Domain toDomainWithParam(String name,String address,Integer age);

    Domain toDomain(Dto dto);

    Dto toDTO(Domain domain);

    List<Domain> toDomainList(List<Dto> customDtoList);

    List<Dto> toDTOList(List<Domain> list);

    Domain merge (Domain domain, Dto dto);
}