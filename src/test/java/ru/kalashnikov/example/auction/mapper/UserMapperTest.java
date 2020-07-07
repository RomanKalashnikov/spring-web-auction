package ru.kalashnikov.example.auction.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import ru.kalashnikov.example.auction.dto.UserDto;
import ru.kalashnikov.example.auction.entity.User;
import ru.kalashnikov.example.auction.mapper.CustomMapper;
import ru.kalashnikov.example.auction.mapper.CustomUserMapperImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Component
class UserMapperTest {

    private final CustomMapper<User, UserDto> userMapper = new CustomUserMapperImpl();



    @Test
    void toDomainList() {
        List<User> newUserList = userMapper.toDomainList(new ArrayList<>());
        assertNotNull(newUserList);

        List<User> nullUserList = userMapper.toDomainList(null);
        assertNotNull(nullUserList);
    }
    @Test
    void toDtoList(){
        List<UserDto> newDtoList = userMapper.toDTOList(new ArrayList<>());
        assertNotNull(newDtoList);

        List<UserDto> NullDtoList = userMapper.toDTOList(null);
        assertNotNull(NullDtoList);
    }


    @Test
    void testNotNullToDomain() {
        User user = userMapper.toDomain(null);
        assertNotNull(user);
    }

    @Test
    void testNotNullToDTO() {
        UserDto userDto = userMapper.toDTO(null);
        assertNotNull(userDto);
    }

    @Test
    void testFullDTO() {
        UserDto userDto = new UserDto();
        userDto.setId((long) 222);
        userDto.setName("Doch");
        userDto.setAge(22);
        userDto.setAddress("asdasdw");

        User user = userMapper.toDomain(userDto);
        assertEquals(userDto.getId(), user.getId());
        assertEquals(userDto.getName(), user.getName());
        assertEquals(userDto.getAddress(), user.getAddress());
        assertEquals(userDto.getAge(), user.getAge());
    }

    @Test
    void mergeNameNotNull() {
        UserDto userDto = new UserDto();
        userDto.setName("Aaa");

        User user = new User();
        userMapper.merge(user, userDto);

        assertNotNull(user.getName());

    }

    @Test
    void mergeAddressNotNull() {
        UserDto userDto = new UserDto();
        userDto.setAddress("Nsk");

        User user = new User();
        userMapper.merge(user, userDto);

        assertNotNull(user.getAddress());

    }

    @Test
    void mergeAgeNotNull() {
        UserDto userDto = new UserDto();
        userDto.setAge(23);

        User user = new User();
        userMapper.merge(user, userDto);

        assertNotNull(user.getAge());

    }
}