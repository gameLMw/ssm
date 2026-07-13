package io.github.gamelmw.spring.ioc.config;

import io.github.gamelmw.spring.ioc.bean.Person;
import io.github.gamelmw.spring.ioc.condition.MacCondition;
import io.github.gamelmw.spring.ioc.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Configuration//告诉Spring这是一个配置类
public class PersonConfig {
    //场景：判断是windows还是mac
    // windows容器有  bill
    // mac容器有  joseph
    @Conditional(MacCondition.class)
    @Bean("joseph")
    public Person personForMac() {
        Person person = new Person();
        person.setName("乔布斯");
        person.setAge(18);
        person.setGender("男");

        return person;
    }

    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person personForWindows() {
        Person person = new Person();
        person.setName("比尔盖茨");
        person.setAge(18);
        person.setGender("男");

        return person;
    }

    @Primary//主组件，默认组件，多个组件时，默认使用
    @Scope("singleton")
    @Bean("zs")//也可以在这里命名组件名字
    public Person person() {
        Person person = new Person();
        person.setName("张三");
        person.setAge(18);
        person.setGender("男");

        return person;
    }

    @Bean("ls")
    public Person person1() {
        Person person = new Person();
        person.setName("李四");
        person.setAge(20);
        person.setGender("男");

        return person;
    }
}
