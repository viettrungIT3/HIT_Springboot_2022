package com.hit.buoi4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${abc}")
    private String appName;

    @GetMapping()
    public String getHome() {
        return appName;
    }

    @GetMapping("{id}")
    public String getID1(@PathVariable("id") String idTemp) {
        return idTemp;
    }

    @GetMapping("{id}/long")
    public String getID1(@PathVariable("id") Long idTemp) {
        return idTemp.toString();
    }
}
