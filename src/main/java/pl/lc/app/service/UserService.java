package pl.lc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lc.app.model.User;
import pl.lc.app.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserDetails(String userName) {
        return userRepository.findByUserName(userName);
    }
}
