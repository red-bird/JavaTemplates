package com.redbird.lesson10.configs;

import com.redbird.lesson10.components.Junior;
import com.redbird.lesson10.components.Middle;
import com.redbird.lesson10.components.Senior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.redbird.lesson10.components")
public class BeanScan {

    private final Junior junior;
    private final Middle middle;
    private final Senior senior;

    @Autowired
    public BeanScan(Junior junior, Middle middle, Senior senior) {
        this.junior = junior;
        this.middle = middle;
        this.senior = senior;
    }

}
