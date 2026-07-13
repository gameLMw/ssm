package io.github.gamelmw.spring.ioc.dao;


import io.github.gamelmw.spring.ioc.bean.Dog;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@ToString
@Repository
public class UserDao {

//    Dog haha;


    /*
     * 构造器注入
     * */
    //Spring会自动去容器中找到构造器所需要的所有参数的组件值
//    public UserDao(Dog dog) {
//        System.out.println("UserDao...有参构造器" + dog);
//        this.haha = dog;
//    }

    Dog dog;

//    @Autowired
//    public void setDog(@Qualifier("dog01") Dog dog) {
//        System.out.println("UserDao...setDog..." + dog);
//        this.dog = dog;
//    }
}
