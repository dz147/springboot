package com.dbcoding.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName: AAA
 * @Description: TODO
 * @Author: Stephen.Zhang
 * @CreateDate: 2020-05-21 16:06
 * @Version: 1.0
 **/
@Component
public class SchedualServiceHiHystric implements SchedualMyService{

    @Override
    public String sayHiFromClientOne(String name) {
        return "I am sorry " + name;
    }
}
