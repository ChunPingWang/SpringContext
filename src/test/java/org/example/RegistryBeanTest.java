package org.example;

import org.example.beans.Duck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
// 可以將 Bean 透過程式的方式加入 Spring Context 中
public class RegistryBeanTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setUp() {
        // 用哪一個 Context Config 皆可
        context = new AnnotationConfigApplicationContext(MultiBeanContextConfig.class);
    }

    @Test
    public void registry_duck_bean_test (){
        Duck duck = new Duck();
        duck.setName("Toy Duck");
        Supplier<Duck> duckSupplier = () -> duck; // 透過 Supplier 來取得 Duck 物件
        context.registerBean("ToyDuck", Duck.class, duckSupplier);

        Duck toyDuck = context.getBean("ToyDuck", Duck.class);
        assertEquals("Toy Duck", toyDuck.getName());
    }
}
