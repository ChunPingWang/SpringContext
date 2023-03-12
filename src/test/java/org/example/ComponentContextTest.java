package org.example;

import org.example.components.Bird;
import org.example.components.Dog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 除了用 Bean 來加入 Spring Context 中，也可以用 Component 來加入
// 透過 @ComponentScan 來將 Component 加入 Spring Context 中
// 請查看 src/main/java/org/example/ComponentContextConfig.java
public class ComponentContextTest {
    private AnnotationConfigApplicationContext context;
    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(ComponentContextConfig.class);
    }

    @Test
    public void context_scan_dog_component_test (){
        Dog dog = context.getBean(Dog.class);
        assertEquals(null, dog.getName());
    }

    // 使用 Component 來加入 Spring Context 中
    // 可在 Component 中使用 @PostConstruct 來初始化 Bean
    // 請查看 src/main/java/org/example/components/Bird.java
    // 在 JDK 11 之後，@PostConstruct 要加上 javax.annotation-api 的依賴
    // 請查看 pom.xml
    @Test
    public void context_post_construct_component_test (){
        Bird bird = context.getBean(Bird.class);
        assertEquals("Parrot", bird.getName());
    }
}
