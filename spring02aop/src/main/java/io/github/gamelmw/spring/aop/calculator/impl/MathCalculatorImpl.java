package io.github.gamelmw.spring.aop.calculator.impl;

import io.github.gamelmw.spring.aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

/*
 * 日志
 * 1. 硬编码，不推荐。高耦合（通用逻辑 + 专用逻辑）
 * 2. 静态代理：
 *      定义：创建一个代理类，包装这个组件。以后业务的执行，从代理开始，不直接调用组件。
 *      特点：定义期间确定代理关系。
 * */

@Component
public class MathCalculatorImpl implements MathCalculator {
    @Override
    public int add(int i, int j) {
        //硬编码日志
//        System.out.println("日志：add开始：" + i + " + " + j);

        int result = i + j;
        System.out.println("结果：" + result);

//        System.out.println("日志：add结束：" + i + " + " + j + " = " + result);

        return result;
    }

    @Override
    public int sub(int i, int j) {
//        System.out.println("日志：sub开始：" + i + " - " + j);

        int result = i - j;

//        System.out.println("日志：sub结束：" + i + " - " + j + " = " + result);

        return result;
    }

    @Override
    public int mul(int i, int j) {
//        System.out.println("日志：mul开始：" + i + " * " + j);

        int result = i * j;

//        System.out.println("日志：mul结束：" + i + " * " + j + " = " + result);

        return result;
    }

    @Override
    public int div(int i, int j) {
//        System.out.println("日志：div开始：" + i + " / " + j);

        int result = i / j;

//        System.out.println("日志：div结束：" + i + " / " + j + " = " + result);

        return result;
    }
}
