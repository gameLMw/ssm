package io.github.gamelmw.spring.aop;

import io.github.gamelmw.spring.aop.calculator.MathCalculator;
import io.github.gamelmw.spring.aop.calculator.impl.MathCalculatorImpl;
import io.github.gamelmw.spring.aop.proxy.statics.CalculatorStaticProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MathTest {

    @Test
    public void test02() {
        //1. 原生对象
        MathCalculator target = new MathCalculatorImpl();
        target.add(1, 2);

        //2. 动态代理
        /*
         * ClassLoader loader           类加载器（目标对象）
         * Class<?>[] interfaces        目标对象实现的接口
         * InvocationHandler h
         * */

        InvocationHandler h = new InvocationHandler() {
            /*
             * proxy:代理对象
             * method:代理对象准备调用的方法
             * args:方法调用的参数
             * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 执行目标方法
                System.out.println("InvocationHandler 的 invoke 在运行");
                
                Object result = method.invoke(target, args);

                return result;
            }
        };

        // 3. 创建代理对象
        MathCalculator proxyInstance = (MathCalculator) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                // InvocationHandler:类似于拦截器
//                (proxy, method, args) -> {
//                    return method.invoke(target, args);
//                }
                h
        );

        int add = proxyInstance.add(1, 2);
        System.out.println("add = " + add);

    }

    @Test
    public void test01() {
        MathCalculator target = new MathCalculatorImpl();
        target.add(1, 2);

        System.out.println("-----------------------");
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(target);
        int add = proxy.add(1, 2);
        System.out.println("add = " + add);
    }
}
