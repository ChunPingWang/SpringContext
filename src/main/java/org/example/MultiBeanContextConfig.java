package org.example;

import org.example.beans.Duck;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MultiBeanContextConfig {
    @Bean
    @Primary
    public Duck redHeadDuck() {
        var duck = new Duck();
        duck.setName("Red Head Duck");
        return duck;
    }
    @Bean(name="rubberDuck")
    public Duck rubberDuck() {
        var duck = new Duck();
        duck.setName("Rubber Duck");
        return duck;
    }
}
