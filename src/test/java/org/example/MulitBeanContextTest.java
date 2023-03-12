package org.example;

import org.example.beans.Duck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 一個 Context 中的多個同Class的Bean，取用會造成 Spring 無法判斷要取用哪一個 Bean
// 這時候就需要用到 @Primary 或 @Qualifier 來區分
// 或是指定 Bean 的名稱
public class MulitBeanContextTest {
    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(MultiBeanContextConfig.class);
    }

    //指定 @Primary 的 Bean
    @Test
    public void context_red_head_duck_test() {
        Duck duck = context.getBean(Duck.class);
        assertEquals("Red Head Duck", duck.getName());
    }

    //指定 Bean 的名稱
    @Test
    public void context_rubber_duck_test() {
        Duck duck = context.getBean("rubberDuck", Duck.class);
        assertEquals("Rubber Duck", duck.getName());
    }
}
