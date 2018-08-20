package pl.lc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lc.app.model.User;
import pl.lc.app.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getUserDetails(String userName) {
        return Optional.ofNullable(userRepository.findByUserName(userName));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<List<User>> getUsers() {
        return Optional.ofNullable(userRepository.findAll());
    }
}
