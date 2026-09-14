package io.github.gamelmw.spring.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect //告诉 Spring 这是组件一个切面类
public class LogAspect {

    /*
     * 告诉 Spring 以下通知方法在何时何地执行
     *   何时？
     *       @Before，方法执行前
     *       @After，方法执行后
     *       @AfterReturning，方法执行正常返回结果后
     *       @AfterThrowing，方法抛出异常后
     *       @Around，方法执行环绕通知
     *   地何？
     *       切入点表达式：execution(方法的全签名)
     *              全写法：[public] int [io.github.gamelmw.spring.aop.calculator.MathCalculator].add(int, int) [throws Exception]
     *              简写法：int add(int, int)
     *              通配符：
     *                  * 表示任意字符
     *                  ..  1.在参数位置，表示多个参数，任意类型
     *                      2.类型位置，表示多个层级
     *              最简略：* *(..)
     * */

    @Before("execution(int io.github.gamelmw.spring.aop.calculator.MathCalculator.*(..))")
    public void logStart() {
        System.out.println("【切面-日志】开始...");
    }

    @After("execution(int io.github.gamelmw.spring.aop.calculator.MathCalculator.*(..))")
    public void logEnd() {
        System.out.println("【切面-日志】结束...");
    }

    @AfterReturning("execution(int io.github.gamelmw.spring.aop.calculator.MathCalculator.*(..))")
    public void logReturn() {
        System.out.println("【切面-日志】返回...");
    }

    @AfterThrowing("execution(int io.github.gamelmw.spring.aop.calculator.MathCalculator.*(..))")
    public void logException() {
        System.out.println("【切面-日志】异常...");
    }
}
