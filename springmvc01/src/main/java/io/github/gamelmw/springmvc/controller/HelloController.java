package io.github.gamelmw.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 告诉 Spring 这是一个控制器类（处理用户请求的组件）
public class HelloController {

    @ResponseBody // 把返回值放到响应体中，每次请求进来执行目标方法
    @RequestMapping("/hello") // 告诉 Spring 这个方法处理 /hello 请求
    public String hello() {
        System.out.println("hello()方法被调用了");
        return "Hello, Spring MVC!";// 默认认为返回值是跳转到一个界面
    }
}
