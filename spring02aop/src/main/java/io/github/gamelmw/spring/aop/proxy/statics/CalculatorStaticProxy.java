package io.github.gamelmw.spring.aop.proxy.statics;

import io.github.gamelmw.spring.aop.calculator.MathCalculator;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/*
* 静态代理：     编码时期就决定代理关系
*   定义：创建一个代理类，包装这个组件。以后业务的执行，从代理开始，不直接调用组件。
*   优点：同一类型的组件，都用同一代理类，可复用
*   缺点：范围小
*
* 动态代理：     运行时决定代理关系
*   定义：目标对象在执行期间会被动态拦截，插入指定逻辑
*   优点：范围大
*   缺点：不好写
* */

//@Component
@ToString
@Data
public class CalculatorStaticProxy implements MathCalculator{

    private MathCalculator target;// 目标对象

    public CalculatorStaticProxy(MathCalculator mc) {
        this.target = mc;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("日志：add开始：" + i + " + " + j);

        int result = target.add(i, j);

        System.out.println("日志：add结束：" + i + " + " + j + " = " + result);

        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = target.sub(i, j);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = target.mul(i, j);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = target.div(i, j);
        return result;
    }
}
