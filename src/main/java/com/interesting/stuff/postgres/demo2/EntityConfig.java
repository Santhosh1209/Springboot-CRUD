package com.interesting.stuff.postgres.demo2;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
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
                    LocalDate.of(2001, Month.AUGUST,22),
                    "Japan"
            );
            Entities Kurosawa = new Entities(
                    "Densetsu",
                    "Kurosawa",
                    "kaiji@gmail.com",
                    "Male",
                    LocalDate.of(2001, Month.AUGUST,22),
                    "Japan"
            );

            // saveAll() saves the data into the database
            entitiesRepository.saveAll(
                    List.of(Kaiji,Kurosawa)
            );
        };
    }
}
