package io.github.gamelmw.spring.ioc.config;

import io.github.gamelmw.spring.ioc.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 * 第三方组件导入容器
 * 1. @Bean:自己new，注册给容器
 * */

@PropertySource("classpath:dog.properties")
@Configuration
public class DogConfig {

    //    @ConditionalOnMissingBean(name = "bill")//没有bill这个bean时创建
//    @ConditionalOnBean(name = "asd")//存在asd这个bean时创建
//    @Lazy
    @Bean
    public Dog dog01() {
        Dog dog = new Dog();
        dog.setName("大狗");

        return dog;
    }

    @Bean
    public Dog dog02() {
        Dog dog = new Dog();
        dog.setName("2狗");

        return dog;
    }
}
