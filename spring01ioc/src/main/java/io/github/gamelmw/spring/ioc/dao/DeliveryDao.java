package io.github.gamelmw.spring.ioc.dao;

import io.github.gamelmw.spring.ioc.datasource.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryDao {

    /*
     * 问题1：数据源不唯一
     *       1.@Primary:dev
     *       2.@Qualifier("dew")
     *               @Profile("环境标识"),当这个环境被激活的时候，这个组件就会生效
     * */

    @Autowired
    MyDataSource myDataSource;

    public void saveDelivery() {
        System.out.println("数据源：保存数据" + myDataSource);
    }
}
