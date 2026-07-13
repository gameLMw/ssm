package io.github.gamelmw.spring.ioc.factory;

import io.github.gamelmw.spring.ioc.bean.Car;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

//场景：如果创建对象比较复杂，那么就可以使用工厂Bean创建对象
@Component
public class BYDFactory implements FactoryBean<Car> {

    /*
     * 调用此方法给容器创建对象
     * */
    @Override
    public @Nullable Car getObject() throws Exception {
        System.out.println("创建Car对象");
        Car car = new Car();
        return car;
    }

    /*
     * 说明返回的类型
     * */
    @Override
    public @Nullable Class<?> getObjectType() {
        return Car.class;
    }

    /*
     * 是单例吗？
     *  true:单例
     *  false:不是单例
     * */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
