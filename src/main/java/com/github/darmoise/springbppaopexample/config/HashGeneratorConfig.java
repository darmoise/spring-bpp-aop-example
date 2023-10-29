package com.github.darmoise.springbppaopexample.config;

import com.github.darmoise.springbppaopexample.util.HashGenerator;
import com.github.darmoise.springbppaopexample.util.IntHashGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HashGeneratorConfig {
    @Bean
    public HashGenerator<Integer> hashGenerator() {
        return new IntHashGenerator();
    }
}
