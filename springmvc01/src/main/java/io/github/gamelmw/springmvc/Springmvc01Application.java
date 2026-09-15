package io.github.gamelmw.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * SpringBoot效果：
 * 1.不用整合Tomcat
 * 2.servlet开发变得简单，不用实现任何接口
 * 3.自动解决了乱码等问题
 * */

@SpringBootApplication
public class Springmvc01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springmvc01Application.class, args);
    }

}
