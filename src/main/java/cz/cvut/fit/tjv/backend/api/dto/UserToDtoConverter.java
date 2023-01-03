package cz.cvut.fit.tjv.backend.api.dto;

import cz.cvut.fit.tjv.backend.domain.User;

import java.util.function.Function;

public class UserToDtoConverter implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setRealName(user.getRealName());
        userDto.setEmail(user.getEmail());  //TODO: add other fields!

        return userDto;
    }
}
