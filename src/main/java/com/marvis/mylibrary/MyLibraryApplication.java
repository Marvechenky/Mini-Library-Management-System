package com.marvis.mylibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MyLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLibraryApplication.class, args);
    }

}
