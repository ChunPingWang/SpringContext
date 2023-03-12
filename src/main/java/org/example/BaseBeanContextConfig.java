package org.example;

import org.example.beans.Duck;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseBeanContextConfig {
    @Bean
    Duck duck() {
        var duck = new Duck();
        duck.setName("Donald");
        return duck;
    }

    @Bean
    String contextString() {
        return "Donald";
    }
}
