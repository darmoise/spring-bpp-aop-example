package com.github.darmoise.springbppaopexample.util.bpp;

import com.github.darmoise.springbppaopexample.util.RandomEmailUtil;
import com.github.darmoise.springbppaopexample.util.annotation.InjectRandomEmail;
import java.lang.reflect.Field;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class InjectRandomEmailBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomEmail.class)) {
                field.setAccessible(true);
                InjectRandomEmail annotation = field.getAnnotation(InjectRandomEmail.class);
                ReflectionUtils.setField(field, bean, RandomEmailUtil.randomEmail(annotation.hosting()));
            }
        }

        return bean;
    }
}
