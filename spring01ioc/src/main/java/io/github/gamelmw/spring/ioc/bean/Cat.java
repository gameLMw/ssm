package io.github.gamelmw.spring.ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

//1. classpath:cat.properties 从自己项目类路经下找
//2. classpath*:cat.properties 从所有包的类路经下找
//@PropertySource("classpath:cat.properties")//说明属性来源
@Data
//@Component
public class Cat {

    @Value("${cat.name:hehe}")//:后面是取不到的时候的默认值
    private String name;

    @Value("${cat.age:20}")
    private int age;
}
