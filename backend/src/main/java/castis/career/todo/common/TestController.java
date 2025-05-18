package castis.career.todo.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping("/exception")
    public void exceptionTest() {
        throw new TestException("TEST");
    }

    @GetMapping("/test")
    public Object test() {
        HashMap<String, String> map = new HashMap<>();
        map.put("data", "null");

        return map;
    }

    @GetMapping("/null")
    public Object nullTest() {
        return "null";
    }
}
