package com.github.darmoise.springbppaopexample.util.bpp;

import com.github.darmoise.springbppaopexample.util.annotation.Logging;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggingBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Class<?>> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> cls = bean.getClass();
        if (cls.isAnnotationPresent(Logging.class)) {
            map.put(beanName, cls);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        val cls = map.get(beanName);

        if (cls != null) {
            return Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    val methodName = method.getName();
                    val argsAsString = Arrays.stream(args)
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));

                    log.info("Start " + methodName + "(" + argsAsString + ")");
                    val retVal = method.invoke(bean, args);
                    log.info("Finish " + methodName);

                    return retVal;
                }
            );
        }

        return bean;
    }
}
