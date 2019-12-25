package demo.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @RequestMapping("/api/test/fun1")
    public String fun1(@RequestParam(required = false, defaultValue = "Hello World") String value) {
        return value;
    }
}
