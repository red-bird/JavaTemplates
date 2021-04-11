package com.redbird.lesson10;

import com.redbird.lesson10.components.Junior;
import com.redbird.lesson10.components.Middle;
import com.redbird.lesson10.components.Senior;
import com.redbird.lesson10.configs.BeanCreate;
import com.redbird.lesson10.configs.BeanScan;
import com.redbird.lesson10.interfaces.Programmer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication

public class Lesson10Application {

    private static void test(ApplicationContext context) {
        if (context == null) {
            throw new NullPointerException();
        }
        System.out.println("------------------------------");
        Programmer programmer = context.getBean(Junior.class);
        System.out.println(programmer.doCoding());

        programmer = context.getBean(Middle.class);
        System.out.println(programmer.doCoding());

        programmer = context.getBean(Senior.class);
        System.out.println(programmer.doCoding());
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
//        SpringApplication.run(Lesson10Application.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanCreate.class);
        test(context);

        ApplicationContext context1 = new AnnotationConfigApplicationContext(BeanScan.class);
        test(context1);
    }

}
