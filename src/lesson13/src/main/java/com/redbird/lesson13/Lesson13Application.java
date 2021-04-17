package com.redbird.lesson13;

import com.redbird.lesson13.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Lesson13Application {

	@Value("${student.name}")
	private String name;
	@Value("${student.last_name}")
	private String lastName;
	@Value("${student.group}")
	private String group;

	public static void main(String[] args) {
		SpringApplication.run(Lesson13Application.class, args);
	}

	@PostConstruct
    public void foo() {
        Student student = new Student(name, lastName, group);
        System.out.println(student);
    }
}