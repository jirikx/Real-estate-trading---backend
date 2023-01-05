package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.api.dto.UserDto;
import cz.cvut.fit.tjv.backend.api.dto.mapper.UserMapper;
import cz.cvut.fit.tjv.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityExistsException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final UserMapper userMapper;

    public UserController(UserService service, UserMapper userMapper) {
        this.service = service;
        this.userMapper = userMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserDto userDto) {
        try {
            service.create(userMapper.toEntity(userDto));
        } catch (EntityExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public UserDto read(@PathVariable Long id) {
        //TODO
        return new UserDto();
    }


}
