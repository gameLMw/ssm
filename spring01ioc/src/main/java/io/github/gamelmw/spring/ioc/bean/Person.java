package io.github.gamelmw.spring.ioc.bean;

import lombok.Data;

@Data
public class Person {
    private String name;

    private Integer age;

    private String gender;

    public Person() {
        System.out.println("创建了一个Person对象");
    }
}
