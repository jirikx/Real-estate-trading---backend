package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.api.dto.UserDto;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.repository.UserRepository;
import cz.cvut.fit.tjv.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.AssertionErrors;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityExistsException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepository;
    @MockBean
    private UserService userService;
    private final UserDto dto = new UserDto(1L,"Matt", "matt@email.com" );
    private final User user = new User(1L,"Matt", "matt@email.com" );
    @Test
    void createTest() {
        Mockito.when(userService.create(user)).thenReturn(user);
        Mockito.when(userService.readById(user.getId())).thenReturn(user);

        userController.create(dto);
        assertEquals("Matt", userController.read(user.getId()).getRealName());
    }

    @Test
    void createDuplicateTest() {
        Mockito.when(userService.create(user)).thenThrow(EntityExistsException.class);

        assertThrows(ResponseStatusException.class, () -> userController.create(dto));
    }
}
