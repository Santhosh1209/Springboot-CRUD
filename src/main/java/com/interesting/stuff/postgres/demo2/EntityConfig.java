package com.interesting.stuff.postgres.demo2;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class EntityConfig {
    @Bean
    // Spring Beans are just instance objects that are created and managed within the Spring framework

    // This method declares a bean of type CommandLineRunner and takes an argument of type EntitiesRepository
    CommandLineRunner commandLineRunner(EntitiesRepository entitiesRepository){
        return  args -> {
            Entities Kaiji = new Entities(
              "Itou",
              "Kaiji",
              "kaiji@gmail.com",
                    "Male",
                    LocalDate.of(2001, AUGUST,22),
                    "Japan"
            );

            Entities Toua = new Entities(
                    "Tokuchi",
                    "Toua",
                    "toua@gmail.com",
                    "Male",
                    LocalDate.of(2003, MARCH,8),
                    "Japan"
            );

            // saveAll() saves the data into the database
            entitiesRepository.saveAll(
                    List.of(Kaiji,Toua)
            );
        };
    }
}
