package io.github.gamelmw.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @ResponseBody
// @Controller
// 告诉 Spring 这是一个控制器类（处理用户请求的组件）
@RestController //前后分离开发大多用这个
public class HelloController {

    /*
     * 路径位置通配符：多个都能匹配上，精确优先
     *       *：匹配任意多个字符（以hello为例，helloooooo）
     *       **：匹配任意多层路径（以hello为例，hello/123/456）
     *       ?：匹配任意一个字符（以hello为例，hell4）
     * 精确程度：完全匹配 > ? > * > **
     * *和?可以写中间，**只能写在末尾
     * */
    @ResponseBody // 把返回值放到响应体中，响应体就是给浏览器的数据。每次进来执行目标方法
    @RequestMapping("/hello") // 告诉 Spring 这个方法处理 /hello 请求
    public String hello() {
        System.out.println("hello()方法被调用了");
        return "Hello, Spring MVC!";// 默认认为返回值是跳转到一个界面
    }

    @ResponseBody
    @RequestMapping("/hell?")
    public String hello01() {
        System.out.println("hello01()方法被调用了");
        return "Hello, Spring MVC!";
    }

    @ResponseBody
    @RequestMapping("/hell*")
    public String hello02() {
        System.out.println("hello02()方法被调用了");
        return "Hello, Spring MVC!";
    }

    @ResponseBody
    @RequestMapping("/hello/**")
    public String hello03() {
        System.out.println("hello03()方法被调用了");
        return "Hello, Spring MVC!";
    }
}
