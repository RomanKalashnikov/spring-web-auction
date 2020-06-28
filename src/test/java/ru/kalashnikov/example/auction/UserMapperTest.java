package ru.kalashnikov.example.auction;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kalashnikov.example.auction.DTO.UserDto;
import ru.kalashnikov.example.auction.entity.User;
import ru.kalashnikov.example.auction.mapper.UserMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UserMapperTest {
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    void testNull() {
        User user = userMapper.toDomain(null);
        assertNull(user);
    }

    @Test
    void testDTO() {
        User user = userMapper.toDomain(new UserDto());
        assertEquals(user, new User());
    }

    @Test
    void testFullDTO() {
        UserDto userDto = new UserDto();
        userDto.setId((long) 222);
        userDto.setName("Doch");
        User user = userMapper.toDomain(userDto);
        assertEquals(userDto.getId(), user.getId());
        assertEquals(userDto.getName(), user.getName());
    }

}