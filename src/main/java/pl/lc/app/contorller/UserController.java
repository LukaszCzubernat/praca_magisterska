package pl.lc.app.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.lc.app.model.User;
import pl.lc.app.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public User getCustomerById(@PathVariable String userName) {
        return userService.getUserDetails(userName);
    }

}
