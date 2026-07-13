package io.github.gamelmw.spring.ioc.service;

import io.github.gamelmw.spring.ioc.bean.Person;
import io.github.gamelmw.spring.ioc.dao.UserDao;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Data
@ToString
@Service
public class UserService {

    //在使用@Primary时，要换一个指定必须使用@Qualifier，变量名为组件名称
    @Qualifier("bill")//精确指定，指定这个组件，名字为bill,但输出组件的名称为person（变量名）
    @Autowired
    Person person;

    /*
     * @Resource 和 @Autowired 区别
     * 1. @Resource 和 @Autowired 都是自动装配，但 @Resource 是jdk提供的，@Autowired 是spring提供的
     * 2. @Resource 具有更强的通用性
     * */
    @Resource
    UserDao userDao;

    //@Resource没有required属性
//    @Autowired(required = false)//允许没有这个bean
//    Dog dog;
}
