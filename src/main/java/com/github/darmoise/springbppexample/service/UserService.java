package com.github.darmoise.springbppexample.service;

import com.github.darmoise.springbppexample.dto.UserDto;
import com.github.darmoise.springbppexample.util.InjectRandomEmail;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UserService {
    @InjectRandomEmail(hosting = "mail.ru")
    private String email;

    public UserDto getUser() {
        return new UserDto(email);
    }
}
