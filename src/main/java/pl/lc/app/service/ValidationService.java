package pl.lc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lc.app.repository.UserRepository;

import java.util.Optional;

@Component
public class ValidationService {

    @Autowired
    UserRepository userRepository;

    public boolean checkUserExistence(String userName) {
        return Optional.ofNullable(userRepository.findByUserName(userName)).isPresent();
    }
}
