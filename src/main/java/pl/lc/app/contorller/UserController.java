package pl.lc.app.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lc.app.model.User;
import pl.lc.app.service.UserService;
import pl.lc.app.service.ValidationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ValidationService validationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getUsers() {
        Optional<List<User>> users = userService.getUsers();
        if(users.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(users.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There no users yet.");
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public ResponseEntity getUserById(@PathVariable String userName) {
        Optional<User> userDetails = userService.getUserDetails(userName);
        if(userDetails.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(userDetails.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no such user.");
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity addUser(@RequestBody User user) {
        if(!validationService.checkUserExistence(user.getUserName())){
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is such user already, pick differnt userName");
    }

}
