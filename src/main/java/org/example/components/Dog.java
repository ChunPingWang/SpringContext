package org.example.components;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
