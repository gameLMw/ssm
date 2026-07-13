package io.github.gamelmw.spring.ioc;

import ch.qos.logback.core.CoreConstants;
import io.github.gamelmw.spring.ioc.bean.*;
import io.github.gamelmw.spring.ioc.controller.UserController;
import io.github.gamelmw.spring.ioc.dao.DeliveryDao;
import io.github.gamelmw.spring.ioc.dao.UserDao;
import io.github.gamelmw.spring.ioc.service.HahaService;
import io.github.gamelmw.spring.ioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/*
 * 这个是主入口类，称为主程序类
 * */

@SpringBootApplication
public class Spring01iocApplication {
    /*
     * 生命周期
     * */
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);
        System.out.println("----------------ioc容器创建完成--------------");

        User bean = ioc.getBean(User.class);
        System.out.println("bean = " + bean);
    }


    /*
     * 原生方式使用Spring容器
     * */
    public static void test13(String[] args) {
        //1. 自己创建IOC容器
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:ioc.xml");
        System.out.println("----------------ioc容器创建完成--------------");

        //2. 获取所有组件名称
        for (String definitionName : ioc.getBeanDefinitionNames()) {
            System.out.println("definitionName = " + definitionName);
        }

        System.out.println("------------------------------");

        //3. 获取组件
        Map<String, Person> type = ioc.getBeansOfType(Person.class);
        System.out.println("type = " + type);

    }


    public static void test12(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);
        System.out.println("----------------ioc容器创建完成--------------");

        DeliveryDao dao = ioc.getBean(DeliveryDao.class);

        dao.saveDelivery();
    }


    public static void test11(String[] args) throws IOException {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);
        System.out.println("----------------ioc容器创建完成--------------");

        Dog bean = ioc.getBean(Dog.class);
        System.out.println("bean = " + bean);

        Cat bean1 = ioc.getBean(Cat.class);
        System.out.println("bean1 = " + bean1);

        File file = ResourceUtils.getFile("classpath:abc.jpeg");
        System.out.println("file = " + file);

        int available = new FileInputStream(file).available();
        System.out.println("available = " + available);
    }


    public static void test10(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);
        System.out.println("----------------ioc容器创建完成--------------");

        HahaService hashService = ioc.getBean(HahaService.class);
        System.out.println("hashService = " + hashService);

        String osType = hashService.getOsType();
        System.out.println("osType = " + osType);

        String myName = hashService.getMyName();
        System.out.println("myName = " + myName);
    }


    public static void tset09(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);
        System.out.println("----------------ioc容器创建完成--------------");

        UserDao bean = ioc.getBean(UserDao.class);
        System.out.println("bean = " + bean);
    }


    public static void test08(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);

        UserService bean = ioc.getBean(UserService.class);
        System.out.println("bean = " + bean);
    }


    public static void test07(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);
        System.out.println("----------------ioc容器创建完成--------------");

        UserController userController = ioc.getBean(UserController.class);
        System.out.println("userController = " + userController);
    }


    /*
     * 条件注册
     *
     * */
    public static void test06(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);

        Map<String, Person> beans = ioc.getBeansOfType(Person.class);
        System.out.println("beans = " + beans);

        // 获取环境对象
        ConfigurableEnvironment environment = ioc.getEnvironment();

        String property = environment.getProperty("os");
        System.out.println("property = " + property);


        /*
         * 为什么 "bill" 和 "dog" 同时出现了？
         *这是问题的核心——@ConditionalOnMissingBean 是在 Bean 定义注册阶段评估的，不是在运行时。
         *Spring 启动时，会按某种顺序处理多个 @Configuration 配置类。如果处理顺序是：
         *  1. 先处理 DogConfig → 检查 @ConditionalOnMissingBean(name = "bill")
         *      此时 PersonConfig 还没处理，"bill" bean 尚未注册
         *      条件结果为 true → Dog 被创建
         *  2.后处理 PersonConfig → WindowsCondition 匹配 → "bill" 被创建
         *结果就是：两个 bean 都存在于容器中。
         *
         *反过来，如果先处理 PersonConfig 再处理 DogConfig，那么 "bill" 已存在，@ConditionalOnMissingBean 就会阻止 Dog 的创建。
         * */
        Map<String, Dog> beansOfType = ioc.getBeansOfType(Dog.class);
        System.out.println("dogs = " + beansOfType);
    }


    //FactoryBean在容器中方放的是组件类型，是接口中泛型的类型，组件的名称是工厂的名字
    public static void test05(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);
        System.out.println("---------------------------------");

        Car bean1 = ioc.getBean(Car.class);
        Car bean2 = ioc.getBean(Car.class);

        System.out.println("bean = " + bean1);
        System.out.println("bean = " + bean2);

        Map<String, Car> beansOfType = ioc.getBeansOfType(Car.class);
        System.out.println("beansOfType = " + beansOfType);
    }


    /*
     * 调整组件的作用域
     * 1. @Scope("prototype"):非单实例
     *      容器启动中不创建对象，但每获取一个，容器会创建一个新对象
     * 2. @Scope("singleton")：单实例,默认
     *      容器启动中创建了一个对象，后面获取的都是同一个对象
     *      @Lazy:懒加载，只有单实例能用，容器启动时不创建对象，第一次使用才创建对象
     * 3. @Scope("request")：同一个请求单实例
     * 4. @Scope("session")：同一次会话单实例
     * */
    public static void test04(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);

        Object zs1 = ioc.getBean("zs");
        Object zs2 = ioc.getBean("zs");
        //@Scope("prototype")
        //容器启动中不创建对象，但每获取一个，容器会创建一个新对象
        System.out.println(zs2 == zs1);// false

        System.out.println("------------------------------");

        //@Scope("singleton")
        //容器启动中创建了一个对象，后面获取的都是同一个对象
        System.out.println(zs1 == zs2);// true

    }


    /*
     * 默认，分层注解使用的前提是，这些组件必须在主程序所在的包及其自包下
     * 但也可以使用@ComponentScan(basePackages = "文件位置")  组件批量扫描。但获取的组件只有文件位置下的，主程序的包的组件可能没有
     *
     * spring为我们提供了快速的MVC分层注解
     * 1，@Controller:控制器
     * 2.@Service:服务层
     * 3.@Repository:持久层
     * 4.@Component:普通组件,底层都是这个组件
     * */
    public static void test03(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);

        System.out.println("----------------ioc容器创建完成--------------");

        UserController bean = ioc.getBean(UserController.class);
        System.out.println("bean = " + bean);

        UserService bean1 = ioc.getBean(UserService.class);
        System.out.println("bean1 = " + bean1);

        System.out.println("------------------------------");

        CoreConstants bean2 = ioc.getBean(CoreConstants.class);
        System.out.println("bean2 = " + bean2);
    }


    /*
     * 组件，框架的底层配置
     *    配置文件,指定配置
     *    配置类(@Configuration):分类管理组件的配置,也是容器的组件
     *
     *  创建时机，容器启动过程中会创建组件对象
     * 单实例特性
     * */
    public static void test02(String[] args) {
        // 1. 启动SpringBoot程序
        // ApplicationContext:SpringBoot应用上下文对象；IoC容器
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);

        System.out.println("----------------ioc容器创建完成--------------");

        // 2. 获取容器中组件
        Dog bean = ioc.getBean(Dog.class);
        System.out.println("bean = " + bean);

        Dog bean1 = ioc.getBean(Dog.class);
        System.out.println("bean = " + bean);

        Dog bean2 = ioc.getBean(Dog.class);
        System.out.println("bean = " + bean);

        Person bean3 = (Person) ioc.getBean("zs");
        System.out.println("bean3 = " + bean3);

        System.out.println("------------------------------");

        for (String definitionName : ioc.getBeanDefinitionNames()) {
            System.out.println("beanName = " + definitionName);
        }


    }


    public static void test01BeanAnnotation(String[] args) {
        // 1. 启动SpringBoot程序
        // ApplicationContext:SpringBoot应用上下文对象；IoC容器
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01iocApplication.class, args);
        System.out.println("ioc" + ioc);

        System.out.println("---------------------");

        // 2. 获取容器中所有的bean(组件)的名称,spring容器会有默认组件
//        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
//        for (String name : beanDefinitionNames) {
//            System.out.println("name = " + name);
//        }


        // 4. 获取容器中的组件对象,精确获取组件
        // 组件的四大特性：名字，类型，对象，作用域
        //组件名唯一，组件名重复，只会获取第一个

        // 从容器中获取组件，
        // 1. 组件不存在，会抛出异常NoSuchBeanDefinitionException
        // 2. 组件不唯一，
        //      按照类型只要一个，会抛出异常NoUniqueBeanDefinitionException
        //      按照名字只要一个，精确获取
        //      多个，返回所有组件的List集合

        // 按照名字获取
        Object person = ioc.getBean("person");
        System.out.println("person = " + person);

        System.out.println("---------------------");

        // 按照类型获取
//        Person person1 = ioc.getBean(Person.class);
//        System.out.println("person1 = " + person1);

        System.out.println("---------------------");

        // 获取组件类型获取全部组件
        Map<String, Person> type = ioc.getBeansOfType(Person.class);
        System.out.println("type = " + type);

        System.out.println("---------------------");

        // 5.组件是单实例的
    }

    // 3. 给容器中注册一个bean，容器中每个组件都有名称，方法名就是组件名称
//    @Bean("张三")//也可以在这里命名组件名字
//    public Person person() {
//        Person person = new Person();
//        person.setName("张三");
//        person.setAge(18);
//        person.setGender("男");
//
//        return person;
//    }
//
//    @Bean("李四")
//    public Person person1() {
//        Person person = new Person();
//        person.setName("李四");
//        person.setAge(20);
//        person.setGender("男");
//
//        return person;
//    }

//    @Bean
//    public Dog dog() {
//        return new Dog();
//    }
}
