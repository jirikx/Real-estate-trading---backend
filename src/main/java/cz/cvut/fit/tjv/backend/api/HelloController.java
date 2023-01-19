package cz.cvut.fit.tjv.backend.api;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Just a silly test method to check the API")
    public String hello() {
        return "hello there";
    }
}
