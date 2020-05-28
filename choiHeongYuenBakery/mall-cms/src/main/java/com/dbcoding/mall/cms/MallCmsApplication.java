package com.dbcoding.mall.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.dbcoding.mall.cms")
@ComponentScan(basePackages = {"com.dbcoding.mall.dao","com.dbcoding.mall.cms"})
@MapperScan(basePackages = "com.dbcoding.mall.dao")
@EnableScheduling //定时任务调度注解，如不添加则无效
public class MallCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallCmsApplication.class, args);
    }

}
