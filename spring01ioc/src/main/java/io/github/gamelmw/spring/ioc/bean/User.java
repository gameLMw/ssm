package io.github.gamelmw.spring.ioc.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

//BeanPostProcessor: Bean的后置处理器(修改器)

@Data
public class User implements InitializingBean, DisposableBean {

    private String name;
    private String password;

    private Car car;


    @Autowired
    public void setCar(Car car) {
        System.out.println("自动注入属性值");
        this.car = car;
    }

    public User() {
        System.out.println("创建了一个User对象");
    }


    @PostConstruct//构造器创建之后调用
    public void postConstruct() {
        System.out.println("postConstruct");
    }

    @PreDestroy//销毁之前调用
    public void preDestroy() {
        System.out.println("preDestroy");
    }


    public void initUser() {
        System.out.println("@bean 初始化 initUser");
    }

    public void destroyUser() {
        System.out.println("@bean 销毁 initUser");
    }


    /*
     * 属性设置之后进行调用，set赋值后进行调用
     * */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }
}
