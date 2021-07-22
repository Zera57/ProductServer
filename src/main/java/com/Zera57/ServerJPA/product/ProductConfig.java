package com.Zera57.ServerJPA.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            ProductRepository repository) {
        return args -> {
            Product cheetos = new Product(
                    "Cheetos Crunchy",
                    "Snack",
                    99,
                    0
            );
            Product redBull = new Product(
                    "RedBull 0.5",
                    "Energy Drink",
                    149,
                    57
            );
            Product twix = new Product(
                    "Twix",
                    "Chocolate",
                    39,
                    89
            );

            repository.saveAll(
                    List.of(cheetos, redBull, twix));
        };
    }
}
