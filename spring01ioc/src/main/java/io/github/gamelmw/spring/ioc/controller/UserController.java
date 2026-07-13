package io.github.gamelmw.spring.ioc.controller;

import io.github.gamelmw.spring.ioc.bean.Person;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@ToString
@Data
@Controller
public class UserController {

    /*
     * 自动装配流程
     * 1. 按照类型，找到这个组件，
     *       1.1 有且只有一个时，名字无关
     *       1.2 多个时，再按照变量名，去容器中找
     * */

    @Autowired //自动装配  原理：spring 调用 容器.getBean()
    Person zs;

    @Autowired
    List<Person> personList;

    @Autowired
    Map<String, Person> personMap;

    @Autowired
    ApplicationContext applicationContext;
}
