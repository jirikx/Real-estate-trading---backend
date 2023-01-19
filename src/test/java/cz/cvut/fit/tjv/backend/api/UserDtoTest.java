package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.api.dto.UserDto;
import cz.cvut.fit.tjv.backend.api.dto.mapper.UserMapper;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

@SpringBootTest
public class UserDtoTest {
    @Autowired
    private UserRepository testUserRepository;

    @Test
    void dtoConverterTest() {
        testUserRepository.deleteAll();
        User testUser = testUserRepository.save(new User("Jan Novak", "jan@novak.cz"));
        Iterable<User> foundUsers = testUserRepository.findAll();
        User foundUser = foundUsers.iterator().next();
        assertEquals(foundUser, testUser);

        UserMapper userMapper = new UserMapper();
        UserDto testUserDto = userMapper.toDto(testUser);
        assertEquals(testUserDto.getId(), testUser.getId());
        assertEquals(testUserDto.getRealName(), testUser.getRealName());
        assertEquals(testUserDto.getEmail(), testUser.getEmail());

        HashSet<Long> testOffers = new HashSet<Long>();
        testOffers.add(1L);
        testOffers.add(2L);

        UserDto wantedDto = new UserDto(1L, "Jan Novak", "jan@novak.cz", testOffers, testOffers);
        //User sampleUser = new User(1L, "Jan Novak", "jan@novak.cz", testOffers, testOffers);
    }
}
