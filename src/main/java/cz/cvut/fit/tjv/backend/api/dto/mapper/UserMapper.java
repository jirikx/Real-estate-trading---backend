package cz.cvut.fit.tjv.backend.api.dto.mapper;

import cz.cvut.fit.tjv.backend.api.dto.UserDto;
import cz.cvut.fit.tjv.backend.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto (User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setRealName(user.getRealName());
        userDto.setEmail(user.getEmail());
        //userDto.setMyOffers(user.getMyOffers().stream().map(Offer::getId).collect(Collectors.toSet()));
        //userDto.setFavouriteOffers(user.getFavouriteOffers().stream().map(Offer::getId).collect(Collectors.toSet()));

        return userDto;
    }

    public User toEntity(UserDto userDto) {
        return new User(userDto.getId(), userDto.getRealName(), userDto.getEmail());    //TODO: will this edit existing object in DB?
    }
}
