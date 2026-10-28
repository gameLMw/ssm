package io.github.gamelmw.springmvc.controller;

import io.github.gamelmw.springmvc.bean.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestTestController {

    /*
     * 使用普通变量，收集请求参数
     * http://localhost:8080/handle01?username=zhangsan&password=12345&cellphone=12345456&agreement=on
     * 请求参数：username=zhangsan&password=12345&cellphone=12345456&agreement=on
     * 1. 没有携带：包装类型自动为null，基本类型自动为0，布尔类型自动为false
     * 2. 变量名和请求参数名一致
     * */
    @RequestMapping("/handle01")
    public String handle01(String username,
                           String password,
                           String cellphone,
                           boolean agreement) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("cellphone:" + cellphone);
        System.out.println("agreement:" + agreement);
        return "ok";
    }

    /*
     * @RequestParam：取出某一个请求参数的值，不能为空
     * 1. 如果请求参数中没有对应的参数名，会报错或者@RequestParam(value = "agreement", required = false) boolean ok
     * 2. 默认值defaultValue = "123456"，有defaultValue参数可以不带
     * */
    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name,
                           @RequestParam(value = "password", required = false, defaultValue = "123456") String pwd,
                           @RequestParam("cellphone") String phone,
                           @RequestParam(value = "agreement", required = false) boolean ok) {
        System.out.println("username:" + name);
        System.out.println("password:" + pwd);
        System.out.println("cellphone:" + phone);
        System.out.println("agreement:" + ok);
        return "ok";
    }

    /*
     * 如果目标方法是一个POJO类型，springMVC会自动把请求参数和POJO的属性进行匹配，把请求参数的值注入到POJO的属性中
     * 1. 请求参数没带，封装为null
     * */
    //请求体：username=zhangsan&password=12345&cellphone=12345456&agreement=on
    @RequestMapping("/handle03")
    public String handle03(Person person) {

        System.out.println(person);
        return "ok";
    }

    @RequestMapping("/handle04")
    public String handle04(@RequestHeader(value = "host", defaultValue = "localhost:8080") String host,
                           @RequestHeader("user-agent") String ua) {
        System.out.println("host:" + host);
        System.out.println("user-agent:" + ua);
        return "ok" + host;
    }

    /*
     * @CookieValue：获取请求头中的Cookie值
     * */
    @RequestMapping("/handle05")
    public String handle05(@CookieValue("haha") String haha) {
        System.out.println("haha:" + haha);
        return "ok";
    }
}
