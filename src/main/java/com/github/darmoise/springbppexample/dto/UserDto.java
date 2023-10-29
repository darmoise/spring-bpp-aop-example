package com.github.darmoise.springbppexample.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class UserDto {
    private UUID id = UUID.randomUUID();
    private String email;

    public UserDto(final String email) {
        this.email = email;
    }
}
