package io.github.gamelmw.spring.aop;

import io.github.gamelmw.spring.aop.calculator.MathCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {

    @Autowired
    MathCalculator mathCalculator;

    @Test
    void test1() {
        System.out.println(mathCalculator);// 实现类

        mathCalculator.add(10, 20);

        System.out.println("--------------");
        mathCalculator.div(10, 20);
    }
}
