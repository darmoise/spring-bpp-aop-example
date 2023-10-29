package com.github.darmoise.springbppexample.controller;

import com.github.darmoise.springbppexample.dto.UserDto;
import com.github.darmoise.springbppexample.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return List.of(userService.getUser());
    }
}
