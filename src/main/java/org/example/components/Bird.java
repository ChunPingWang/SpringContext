package org.example.components;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bird {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @PostConstruct
    public void init() {
        this.name = "Parrot";
    }
}
