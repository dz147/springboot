package com.dbcoding.mall.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.dbcoding.mall.website")
@ComponentScan(basePackages = {"com.dbcoding.mall.dao","com.dbcoding.mall.website"})
@MapperScan(basePackages = "com.dbcoding.mall.dao")
@EnableScheduling //定时任务调度注解，如不添加则无效
@EnableCaching
public class MallWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebsiteApplication.class, args);
    }

}
