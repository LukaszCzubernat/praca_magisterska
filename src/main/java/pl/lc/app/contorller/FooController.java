package pl.lc.app.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class FooController {

    @RequestMapping(value = "/foo", method = POST)
    public String foo() {
        return "Test foo controller";
    }
}
