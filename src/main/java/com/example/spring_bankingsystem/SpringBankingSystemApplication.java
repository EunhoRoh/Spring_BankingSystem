package com.example.spring_bankingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = {"com.example.spring_bankingsystem.mapper"})
public class SpringBankingSystemApplication {

    public static void main(String[] args) {


        SpringApplication.run(

                SpringBankingSystemApplication.class, args);
    }

}
