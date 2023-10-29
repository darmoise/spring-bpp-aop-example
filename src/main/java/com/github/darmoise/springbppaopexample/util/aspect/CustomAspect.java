package com.github.darmoise.springbppaopexample.util.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class CustomAspect {

    @Pointcut("@annotation(com.github.darmoise.springbppaopexample.util.annotation.AspectAnnotation)") // по аннотации определяем за каким методом следить
    //@Pointcut("execution(public * com.github.darmoise.springbppexample.service.UserService.getUser())") // по названию метода
    public void callAtGetUser() { }

    @Before("callAtGetUser()")
    public void beforeCallAtGetUser() {
        log.info("Called before getUser");
    }

    @After("callAtGetUser()")
    public void afterCallAtGetUser() {
        log.info("Called after getUser");
    }
}
