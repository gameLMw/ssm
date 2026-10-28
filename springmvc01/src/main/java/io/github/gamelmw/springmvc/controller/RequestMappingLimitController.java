package io.github.gamelmw.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingLimitController {

    /*
     * 请求方式
     * GET,HEAD, POST, PUT, DELETE, OPTIONS, TRACE
     * */
    @RequestMapping(value = "/test01", method = {RequestMethod.POST, RequestMethod.GET})
    public String test01() {
        return "test01";
    }


    /*
     * 请求参数:params = {"username", "age"}
     * 1. username 表示请求必须包含username参数
     * 2. age=18 表示请求必须包含age参数，且age的值必须为18
     * */
    @RequestMapping(value = "/test02", params = "age=18") //不可以有空格：params = "age = 18"
    public String test02() {
        return "test02";
    }
}
