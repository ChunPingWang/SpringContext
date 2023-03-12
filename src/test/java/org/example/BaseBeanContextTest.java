package org.example;

import org.example.beans.Duck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


// 基礎的 Bean Context 示範
// 透過 @Bean 來註冊 Bean
// 請查看 src/main/java/org/example/BaseBeanContextConfig.java
public class BaseBeanContextTest {
    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(BaseBeanContextConfig.class);
    }

    @Test
    public void context_duck_test() {
        Duck duck = context.getBean(Duck.class);
        assertEquals("Donald", duck.getName());
    }

    @Test
    public void context_string_test() {
        assertEquals("Donald", context.getBean(String.class));
    }


}
