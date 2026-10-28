package io.github.gamelmw.springmvc.bean;

import lombok.Data;

@Data
public class Person {
    //username=zhangsan&password=12345&cellphone=12345456&agreement=on
    //变量名要一致
    private String username;//request.getParameter("username"),自动封装
    private String password = "123456";//默认值123456
    private String cellphone;
    private boolean agreement;
}
