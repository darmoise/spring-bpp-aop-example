package com.github.darmoise.springbppaopexample.service;

import com.github.darmoise.springbppaopexample.dto.UserDto;
import com.github.darmoise.springbppaopexample.util.HashGenerator;
import com.github.darmoise.springbppaopexample.util.annotation.AspectAnnotation;
import com.github.darmoise.springbppaopexample.util.annotation.InjectRandomEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UserService {
    private final HashGenerator<Integer> hashGenerator;

    @InjectRandomEmail(hosting = "mail.ru")
    private String email;

    @AspectAnnotation
    public UserDto getUser() {
        return new UserDto(
            email,
            hashGenerator.hash(email)
        );
    }
}
