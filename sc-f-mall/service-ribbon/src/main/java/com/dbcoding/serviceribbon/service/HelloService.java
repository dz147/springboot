package com.dbcoding.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: AAA
 * @Description: TODO
 * @Author: Stephen.Zhang
 * @CreateDate: 2020-05-21 11:33
 * @Version: 1.0
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    //创造熔断功能 并指定熔断方法 直接返回一个字符串
    @HystrixCommand(fallbackMethod = "myError")
    public String myService(String name) {
        return restTemplate.getForObject("http://SERVICE-CLIENT/hi?name=" + name, String.class);
    }

    public String myError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
