package io.github.gamelmw.spring.ioc.config;

import io.github.gamelmw.spring.ioc.datasource.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

    //利用条件注解，只在某一种环境激活某一个组件,多环境

    //1. 定义环境标识：
    //          自定义：dev,prod,test
    //          默认： default
    //2. 激活环境标识：
    //          明确告诉spring当前处于哪个环境
    //          默认环境为 default 环境

    @Profile({"dev", "default"})//@Profile("环境标识"),当这个环境被激活的时候，这个组件就会生效
    @Bean
    public MyDataSource dev() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/dev");
        myDataSource.setUsername("dev_user");
        myDataSource.setPassword("dev_pwd");

        return myDataSource;
    }

    @Profile("prod")
    @Bean
    public MyDataSource prod() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/prod");
        myDataSource.setUsername("prod_user");
        myDataSource.setPassword("prod_pwd");

        return myDataSource;
    }

    @Profile("test")
    @Bean
    public MyDataSource test() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        myDataSource.setUsername("test_user");
        myDataSource.setPassword("test_pwd");

        return myDataSource;
    }
}
