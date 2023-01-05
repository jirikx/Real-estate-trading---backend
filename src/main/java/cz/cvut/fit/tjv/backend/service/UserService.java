package cz.cvut.fit.tjv.backend.service;

import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CommonCrudService<User, Long> {
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
