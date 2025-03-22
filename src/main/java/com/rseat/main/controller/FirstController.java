package com.rseat.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/firstController")
public class FirstController {

    @GetMapping()
    public String firstController() {
        return "Hello World";
    }

    @GetMapping("/path/{id}")
    public String getWithPathVariable(@PathVariable Long id) {
        return "Hello World: " + id ;
    }


    @GetMapping("/path")
    public String getWithParam(@RequestParam Map<String, String> params) {
        return "Hello World: " + params.entrySet() ;
    }

    @PostMapping()
    public String post(@RequestBody User user) {
        return "Hello World: " + user.username ;
    }

    @PostMapping("withHeader")
    public String postWithHeader(@RequestHeader("name") String name) {
        return "Hello World: " + name ;
    }


    @PostMapping("withHeaderList")
    public String postWithHeaderList(@RequestHeader Map<String, String> headers) {
        return "Hello World: " + headers.entrySet() ;
    }

    @PostMapping("responseEntity/{id}")
    public ResponseEntity<Object> postWithHeaderList(@PathVariable Long id) {
        if (id < 5) {
            return ResponseEntity.badRequest().body("id is less than 5");
        }

        var user = new User("Gabriel");

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    record User(String username) {}
}
