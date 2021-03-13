package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

        @Bean
        CommandLineRunner commandLineRunner(
                StudentRepository repository) {
            return args -> {
                Student mariam = new Student(
                        1L,
                        "mariam",
                        "olisaejikeme@gmail.com",
                        LocalDate.of(2001, Month.DECEMBER, 6),
                        21
                );

                Student alex = new Student(
                        1L,
                        "Alex",
                        "alex@gmail.com",
                        LocalDate.of(1999, Month.DECEMBER, 21),
                        23
                );

                repository.saveAll(
                        List.of(mariam, alex)
                );
            };
        }
}
