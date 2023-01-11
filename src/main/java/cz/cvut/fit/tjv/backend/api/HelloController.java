package cz.cvut.fit.tjv.backend.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${apiPrefix}/hello")
public class HelloController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "hello there";
    }
}
