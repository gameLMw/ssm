package io.github.gamelmw.spring.ioc.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

//@PropertySource("classpath:dog.properties")//说明属性来源
@ToString
@Data
//@Component
public class Dog {

//    @Autowired//自动注入组件，不能注入基本类型

    /*
     * 1. @Value("值")：直接赋值
     * 2. @Value("${key}")：动态取出，从配置文件中获取值
     * 3. @Value("#{SpEL}")：Spring Expression Language，Spring表达式语言
     * */
    @Value("旺财")
    private String name;

    @Value("${dog.age}")
    private Integer age;

    @Value("#{10*20}")
    private String color;

    @Value("#{T(java.util.UUID).randomUUID().toString()}")
    private String id;

    @Value("#{'Hello World!'.substring(0,5)}")
    private String msg;

    @Value("#{1>2?'haha':'hehe'}")
    private String flag;

    public Dog() {
        String string = UUID.randomUUID().toString();
        System.out.println("创建了一个Dog对象");
    }
}
