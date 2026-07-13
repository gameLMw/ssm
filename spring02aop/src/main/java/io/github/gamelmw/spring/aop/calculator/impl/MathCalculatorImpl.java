package io.github.gamelmw.spring.aop.calculator.impl;

import io.github.gamelmw.spring.aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

@Component
public class MathCalculatorImpl implements MathCalculator {
    @Override
    public int add(int i, int j) {

        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
