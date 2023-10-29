package com.github.darmoise.springbppexample.config;

import com.github.darmoise.springbppexample.util.HashGenerator;
import com.github.darmoise.springbppexample.util.IntHashGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HashGeneratorConfig {
    @Bean
    public HashGenerator<Integer> hashGenerator() {
        return new IntHashGenerator();
    }
}
