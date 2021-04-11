package com.redbird.lesson10.configs;

import com.redbird.lesson10.components.Junior;
import com.redbird.lesson10.components.Middle;
import com.redbird.lesson10.components.Senior;
import com.redbird.lesson10.interfaces.Programmer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCreate {

    @Bean
    public Programmer hireJunior() {
        return new Junior();
    }

    @Bean Programmer hireMiddle() {
        return new Middle();
    }

    @Bean Programmer invokeSenior() {
        return new Senior();
    }

}
