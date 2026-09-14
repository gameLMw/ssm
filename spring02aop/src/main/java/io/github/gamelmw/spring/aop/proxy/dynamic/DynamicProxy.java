package io.github.gamelmw.spring.aop.proxy.dynamic;

import io.github.gamelmw.spring.aop.log.LogUtils;

import java.lang.reflect.Proxy;

/*
 * 动态代理：JDK动态代理：强制要求，目标对象必须要有接口，代理的也只是接口规定的方法
 * */

public class DynamicProxy {
    public static Object getProxyInstance(Object target) {

        return Proxy.newProxyInstance(
                /*
                 * 参数1：类加载器
                 * 作用：
                 *      1.获取 target 对象的类加载器
                 *      2.告诉 JVM："用这个加载器来加载我即将生成的代理类"
                 *
                 * 保证代理类和目标类在同一个类加载空间
                 * 避免类加载冲突
                 * */
                target.getClass().getClassLoader(),
                /*
                 * 参数2：接口数组
                 * 作用：
                 *      1.获取 target 实现的所有接口
                 *      2.告诉 JVM："生成的代理类要实现这些接口"
                 *
                 * JDK 动态代理只能代理接口
                 * 如果 target 没有实现任何接口，这里返回空数组，会报错
                 * */
                target.getClass().getInterfaces(),
                /*
                 * 参数3：InvocationHandler（核心逻辑）
                 * Lambda 的三个参数:
                 *      1. proxy(Object):代理对象本身
                 *      2. method(Method):当前被调用的方法对象
                 *      3. args(Object[]):调用方法时传入的参数数组
                 * */
                (proxy, method, args) -> {
                    String name = method.getName();
//                    System.out.println("【日志】：【" + name + "】开始：参数：" + Arrays.toString(args));
                    // 记录开始
                    Object result = null;
                    LogUtils.logStart(name, args);
                    try {
                        result = method.invoke(target, args);
                        // 记录返回值
//                        System.out.println("【日志】：【" + name + "】返回：返回结果：" + result);
                        LogUtils.logReturn(name, result);
                    } catch (Exception e) {
                        // 记录异常
//                        System.out.println("【日志】：【" + name + "】发生错误：错误结果：" + e.getMessage());
                        LogUtils.logException(name, e);
                    } finally {
                        // 记录结束
//                        System.out.println("【日志】：【" + name + "】结束：");
                        LogUtils.logEnd(name);
                    }
                    return result;
                }
        );
    }
}
