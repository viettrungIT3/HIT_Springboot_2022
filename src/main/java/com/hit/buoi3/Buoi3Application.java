package com.hit.buoi3;

import com.hit.buoi3.controllers.AppControllor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Buoi3Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Buoi3Application.class, args);

//        AppControllor app = context.getBean(AppControllor.class);
//        System.out.println(app);
//

    }

}
