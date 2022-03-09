package com.hit.btvn3;

import com.hit.btvn3.model.Store;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Btvn3Application {

    public static void main(String[] args) {
        SpringApplication.run(Btvn3Application.class, args);

        System.out.println(Store.users.get(2).getId());
    }

}
