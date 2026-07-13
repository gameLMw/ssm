package io.github.gamelmw.spring.aop;

import io.github.gamelmw.spring.aop.calculator.MathCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spring2aopApplicationTests {

    //设计模式：依赖倒置原（依赖接口，不要依赖实现）

    @Autowired
    MathCalculator mathCalculator;

    @Test
    void contextLoads() {

        int add = mathCalculator.add(1, 2);

        System.out.println("add = " + add);
    }

}
