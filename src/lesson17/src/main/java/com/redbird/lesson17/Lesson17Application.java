package com.redbird.lesson17;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class Lesson17Application {

    @Value("${timezone}")
    private String timezone;

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone(timezone));
    }

    public static void main(String[] args) {
        SpringApplication.run(Lesson17Application.class, args);
    }

}
