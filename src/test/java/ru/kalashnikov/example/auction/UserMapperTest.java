package ru.kalashnikov.example.auction;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import ru.kalashnikov.example.auction.dto.UserDto;
import ru.kalashnikov.example.auction.entity.User;
import ru.kalashnikov.example.auction.mapper.CustomMapper;
import ru.kalashnikov.example.auction.mapper.CustomUserMapperImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Component
class UserMapperTest {

    private final CustomMapper<User, UserDto> userMapper = new CustomUserMapperImpl() ;

    @Test
    void testNotNull() {
        User user = userMapper.toDomain(null);
        assertNotNull(user);
    }

    @Test
    void testDTO() {
        User user = userMapper.toDomain(new UserDto());
        assertEquals(new User(),user);
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
        assertEquals(userDto.getAddress(),user.getAddress());
        assertEquals(userDto.getAge(),user.getAge());
    }

}