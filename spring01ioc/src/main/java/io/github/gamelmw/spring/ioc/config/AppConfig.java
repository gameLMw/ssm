package io.github.gamelmw.spring.ioc.config;

import ch.qos.logback.core.CoreConstants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({CoreConstants.class})
@Configuration
@ComponentScan(basePackages = "io.github.gamelmw.spring1")//扫描指定包下的所有组件
public class AppConfig {
}
