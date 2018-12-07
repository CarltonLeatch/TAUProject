package com.SteamLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.SteamLibrary.Model")
@ComponentScan("com.SteamLibrary.*")
@SpringBootApplication
public class SteamLibrary {

    public static void main(String[] args){
        SpringApplication.run(SteamLibrary.class, args);
    }
}
